javac -d build -sourcepath src -cp lib/Pokemon.jar src/PokeLab.java
echo -e 'Main-Class: PokeLab\nClass-Path: lib/Pokemon.jar' > MANIFEST.mf
jar cfm lab2.jar MANIFEST.mf -C build .
rm -rf build MANIFEST.mf
