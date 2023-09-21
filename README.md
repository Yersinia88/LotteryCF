# LotteryCF
Találatszámlálás hatos lottón CF

Markos András
Owned by Markos András

2021. 05. 06.3 min readLegacy editor
Feladat
Írj Java programot hatos lottóval kapcsolatos találatszámlálós feladatok megoldására. A projekt neve LotteryCF.

A program megírásához a Collections Framework eszköztárát használd.

A részfeladatok megoldásai kerüljenek – egy közös package-en belül – egy-egy osztálydefinícióba. Az alábbi specifikációból viszont az látható, hogy az osztályok hasonlóak, pontosabban funkcionálisan átfedést mutatnak. Ennek kapcsán ügyelj arra, hogy a kód ne legyen redundáns, azaz az osztályok kódjának közös részét emeld ki pl. absztrakt osztályba, vagy az osztályok épüljenek megfelelően egymásra.

1. részfeladat
Képzeljünk el egy olyan személyt, aki a hatos lottón mindig ugyanazokkal a számokkal játszik. Ennek megfelelően a program kezdetben bekéri a standard bemenetről e virtuális szelvény számait. (Ha egy szám megadásakor bármilyen gond adódna, a program egyszerűen ismét bekéri a számot.)

Ezt követően a program addig "sorsol" (az 1-től 45-ig terjedő tartományból) számhatosokat, amíg a szelvény telitalálatos nem lesz, azaz amíg elő nem áll a teljes egyezés az előre megadott számokkal.

Ekkor kilistázza, hogy a szelvény hány sorsoláson ért el sorrendben nulla, egy, kettő, három, négy, öt, ill. hat találatot. E számok mellé továbbá odaírja azt is, hogy a sorsolások teljes számához képest ezek relatíve mekkora gyakoriságokat jelentenek.

Legyen az osztály neve RandomDraws.

2. részfeladat
Vegyük ismét a rögzített számokkal játszó képzeletbeli személyt. A program tehát ezúttal is azzal indul, hogy bekéri a standard bemenetről a szelvény számait.

Most azonban kapcsoljuk ki a véletlent a sorsolásokból: a program "gyártsa le" minden lehetséges sorsolás eredményét. Pontosabban képezzen egy olyan sort (queue-t), amely tartalmazza az összes lehetséges számhatost (egy-egy gyűjteményobjektumként).

A program ezt követően ezúttal is kilistázza, hogy a szelvény a queue-ban szereplő sorsolások közül hányban ért el sorrendben nulla, egy, kettő, három, négy, öt ill. hat találatot, és a számok mellé kiírja a megfelelő gyakoriság adatot is. A találatszámlálás során a program járjon el úgy, hogy a már feldolgozott sorsolásokat menet közben törli a queue-ből. (Azaz a feldolgozás végére a queue kiürül.)

Legyen az osztály neve TotalDraws.
