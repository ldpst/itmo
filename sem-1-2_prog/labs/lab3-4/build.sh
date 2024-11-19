javac -d build -sourcepath src src/Main.java
echo -e 'Main-Class: Main' > MANIFEST.mf
jar cfm lab3-4.jar MANIFEST.mf -C build .
rm -rf build MANIFEST.mf
