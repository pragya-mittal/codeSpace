function trackid { 
  wget "https://soundcloud.com/search/sounds?q=$title $artist" -O "soundcloud.log"
  suffix=`grep '<li><h2>' -m 1 soundcloud.log | awk -F '"' '{print $2}'`
  wget "https://soundcloud.com$suffix" -O "soundcloudsong.log"
  soundcloudtrackid=`grep -o "api.soundcloud.com%2Ftracks%2F.*&amp" "soundcloudsong.log" | awk -F'tracks%2F' '{print $2}' | awk -F'&' '{print $1}'`
}

DATE=`date +%Y-%m-%d`
wget "http://www.billboard.com/rss/charts/hot-100" -O "hot-100-$DATE"
trackcount=$(xmllint --xpath 'count(//item)' hot-100-$DATE.xml)
output="hot-100-$DATE.json"

tracks=`xmllint --xpath '\\item\\track'`
artists=`xmllint --xpath '\\item\\artist'`

i=1
echo "{" > $output
while [ $i -le $trackcount ]
do
  title=`xmllint --xpath "//item[$i]//title/text()" hot-100-$DATE.xml | sed 's/.*: //'`
  artist=`xmllint --xpath "//item[$i]//artist/text()" hot-100-$DATE.xml`
  trackid
  echo "\"$i\":{" >> $output
  echo "\"title\":\"$title\"," >> $output
  echo "\"artist\":\"$artist\"," >> $output
  echo "\"trackid\":\"$soundcloudtrackid\"" >> $output
  echo "}," >> $output
  i=`expr $i + 1`
done

sed -i -e '$ s/.$/\n}/' $output
