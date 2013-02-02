# FireGame

## Instructions for OS X

### 1. Open the project using [IntelliJ](http://www.jetbrains.com/idea/download/)
- Install it if you don’t have it

### 2. Add processing to the project module from global libraries
- Install [Processing](http://processing.org) if you don’t have it.
- Go to File -> Project Structure -> Global Libraries
- If ‘core’ library from processing is not in the list you need to add it. Pluss icon -> Java. Browse to /Applications/Processing.app/Contents/Resources/Java/core.jar.
- Right click ‘core’ -> Add to modules -> Select Fire game -> Ok.

### 3. Add minim libraries to the project module from global libraries.
- Go to File -> Project Structure -> Global Libraries
- If minim libraries is not in the list you need to add it (it is one entry that includes many classes). Plus icon -> Java. Browse to /Applications/Processing.app/Contents/Resources/Java/modes/java/libraries/minim/library/ and select all the *.jar files in that directory. Click ok.
- Right click ‘minim’ -> Add to module -> Select Fire Game -> Ok.

### 4. Download jinput and put them in the Java Native Library Path.
- Download the latest version of [jinput](http://www.newdawnsoftware.com/resources/jinput/).
- Open /usr/lib/java and copy libjinput-osx.jnilib to that directory.

### 5. Connect a wired Xbox360 gamepad if you have one. 
- Requires [drivers](http://tattiebogle.net/index.php/ProjectRoot/Xbox360Controller/OsxDriver) to work.

### 6. Hit play!
