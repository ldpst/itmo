javac Main.java
echo -e 'Main-Class: Main' > MANIFEST.mf
jar cfm lab3-4.jar MANIFEST.mf -C build .