javac Main.java
echo -e 'Main-Class: Main' > MANIFEST.mf
jar -cmf MANIFEST.mf Main.jar .
