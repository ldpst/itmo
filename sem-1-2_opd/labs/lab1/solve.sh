#-------------Пункт №1-------------

mkdir lab0
cd lab0
touch beheeyem4
echo Тип диеты Nullivore > beheeyem4
mkdir metagross6
cd metagross6
mkdir ninjask
mkdir nosepass
touch wooper
echo -e 'weigth=18.7 height=16.0 atk=5\ndef=5' > wooper
touch kricketune
echo -e 'Возможности Overland=8 Surface=3 Sky=5 Jamp=3\nPower2=0 Intelligence=4' > kricketune
touch armaldo
echo -e 'Способности Mountain Peak Swarm\nBattle Armor Rock Head' > armaldo
cd ..
touch noctowl6
echo -e 'Развитые способности Tinted\nLens' > noctowl6
mkdir pansage6
cd pansage6
touch xatu
echo -e 'Ходы Air Cutter Double-Edge Foul Play Giga Drain Heat Wave\nMagic Coat Magic Room Pain Split Ominous Wind Role Play Roost Signal\nBeam Silver Wind Skill Swap Sky Attack Sleep Talk Snore Steel Wing\nSucker Punch Swift Tailwind Trick Twister Zen\nHeadbutt' > xatu
mkdir haxorus
mkdir purrloin
mkdir aipom
mkdir lilligant
cd ..
mkdir shelgon9
cd shelgon9
mkdir charizard
mkdir hoothoot
touch munchlax
echo Развитые способности Gluttony > munchlax
cd ..
touch togetic0
echo -e 'Живет\nForest Rainforest' > togetic0
cd ..

#-------------Пункт №2-------------

cd lab0
chmod 624 beheeyem4
chmod 335 metagross6
cd metagross6
chmod u+rx-w ninjask
chmod g+rwx ninjask
chmod o+rwx ninjask
chmod 500 nosepass
chmod 046 wooper
chmod 066 kricketune
chmod u-rwx armaldo
chmod g-rwx armaldo
chmod u+rw-x armaldo
cd ..
chmod 660 noctowl6
chmod 737 pansage6
cd pansage6
chmod 666 xatu
chmod 737 haxorus
chmod 512 purrloin
chmod 755 aipom
chmod 752 lilligant
cd ..
chmod u+rwx shelgon9
chmod g-r+wx shelgon9
chmod o+rwx shelgon9
cd shelgon9
chmod 551 charizard
chmod 500 hoothoot
chmod 044 munchlax
cd ..
chmod 004 togetic0
cd ..

#-------------Пункт №3-------------

cd lab0
ln -sf pansage6 Copy_9
ln -f noctowl6 metagross6/woopernoctowl
chmod 400 metagross6/kricketune
cat metagross6/kricketune metagross6/armaldo > beheeyem4_97
chmod 066 metagross6/kricketune
chmod 700 shelgon9/hoothoot
chmod 400 shelgon9/munchlax
cp -r shelgon9 shelgon9/hoothoot
chmod 500 shelgon9/hoothoot
chmod 044 shelgon9/munchlax
cp noctowl6 shelgon9/munchlaxnoctowl
chmod 400 togetic0
cp -f togetic0 pansage6/aipom
chmod 004 togetic0
ln -sf noctowl6 metagross6/kricketunenoctowl
cd ..

#-------------Пункт №4-------------

cd lab0
echo -e '\n========4.1========\n'
wc -m beheeyem4 >> beheeyem4 2>&1
cat beheeyem4
echo -e '\n========4.2========\n'
ls -Rl 2>&1 | grep 't$' | sort -k 9 | tail -n 2
echo -e '\n========4.3========\n'
cat h* */h* */*/h* */*/*/h* 2> /dev/null | sort 1> tmp123
cat -n tmp123
rm tmp123
echo -e '\n========4.4========\n'
ls -ltR 2>tmp | grep " a"
echo -e '\n========4.5========\n'
ls -lrRS | grep -ve "/" -ve "итог" -ve "^$" -ve ":$" | sort -gk 5 | tail -n 2
echo -e '\n========4.6========\n'
cat *6 */*6 */*/*6 */*/*/*6 2>tmp | sort
echo
cd ..

#-------------Пункт №5-------------

cd lab0
rm -f beheeyem4
chmod 777 metagross6
cd metagross6
rm -f kricketune
rm kricketunenocto*
rm woopernocto*
cd ..
chmod 335 metagross6
rm -rf pansage6
rm -rf pansage6/lilligant
cd ..
