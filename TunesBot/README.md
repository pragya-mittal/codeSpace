Tool to download songs.

Configure the config.yml accordingly before proceeding.

Steps are :
1. cd $CURRENT_DIR
2. git clone https://github.com/pragya-mittal/codeSpace.git
3. cd $CURRENT_DIR/codespace/TunesBot
4. mvn clean install
5. Bring up server :
  a. via command ->
   java -jar target/TunesBot-1.0-SNAPSHOT.jar server $CURRENT_DIR/codeSpace/TunesBot/src/main/resources/config.yml
   OR
  b. via Intellij ->
   Goto Edit Configurations. In program arguements add :
   server $CURRENT_DIR/codeSpace/TunesBot/src/main/resources/config.yml
   Run DownloadServer.java
6. APIS :
   a. localhost:8080/music/getMusicList
   b. localhost:8080/music/getMusic?trackId=abcde
