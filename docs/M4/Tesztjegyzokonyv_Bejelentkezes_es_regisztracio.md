# Tesztjegyzőkönyv-`Felhasználók létrehozása és bejelentkeztetése`

Az alábbi tesztdokumentum a `IMDB` projekthez tartozó `9.4.5. Felhasználók létrehozásának és bejelentkeztetésének (TP, TC, TR)` funkcióihoz készült. 
Felelőse: `Dobó Csenge` 


## 1. Teszteljárások (TP)

### 1.1. Regisztráció tesztelése
- Azonosító: TP-01
- Tesztesetek: TC-01
- Leírás: regisztráció tesztelése
    0. lépés: Menjünk a bejelentkezés menüpontra, majd kattintsunk a `Még nem regisztráltál az oldalra? Kattints ide!` linkjére.
    1. lépés: Töltsük ki az input mezőket a saját adatainkal, odafigyelve a két megadott jelszó egyezésére, az email cím formaiságára és a születési dátum formaiságára majd nyomjuk meg a Regisztráció gombot.
    2. lépés: Ha még nem létező felhasználónév, két azonos jelszó lett megadva az inputokba, a megadott email címben szerepel a @ jel és a számokkal megadott születési dátum év, hónap, nap, "-" jellel történő elválasztására, akkor az adatok bekerülnek az adatbázisba. Elvárt eredmény: `Alul kiíródik, hogy "Sikeres regisztráció"`
    
### 1.2. Bejelentkezés tesztelése
- Azonosító: TP-02
- Tesztesetek: TC-02
- Leírás: bejelentkezés tesztelése
    0. lépés: Menjünk a bejelentkezés menüpontra.
    1. lépés: Töltsük ki az input mezőket a regisztrációnál megadott felhasználónévvel és jelszóval, majd nyomjuk meg a Bejelentkezés gombot.
    2. lépés: Ha helyesen lettek megadva az inputok, akkor a bejelentkezés sikeres volt. Elvárt eredmény: `Vissza kerülünk a főoldalra és megjelennek a bejelentkeztetett felhasználók számára elérhető funkciók`

## 2. Teszesetek (TC)

### 2.1.  Regisztráció tesztelése

#### 2.1. TC-01
- TP: TP-01
- Leírás: regisztráció tesztelése
- Művelet: Töltsük ki az input mezőket a saját adatainkal, odafigyelve a két megadott jelszó egyezésére, az email cím formaiságára és a születési dátum formaiságára majd nyomjuk meg a Regisztráció gombot.
- Elvárt kimenet: Ha még nem létező felhasználónév, két azonos jelszó lett megadva az inputokba, a megadott email címben szerepel a @ jel és a számokkal megadott születési dátum év, hónap, nap, "-" jellel történő elválasztására akkor alul kiíródik, hogy "Sikeres regisztráció".

### 2.2.  Bejelentkezés tesztelése

#### 2.2. TC-02
- TP: TP-02
- Leírás: bejelentkezés tesztelése
- Művelet: Töltsük ki az input mezőket a regisztrációnál megadott felhasználónévvel és jelszóval, majd nyomjuk meg a Bejelentkezés gombot.
- Elvárt kimenet: Ha helyesen lettek megadva az inputok, akkor átkerülünk a főoldalra és megjelennek a bejelentkezett felhasználók számára elérhető funkciók.

## 3. Tesztriportok (TR)

### 3.1. A regisztráció tesztriportjai

#### 3.1.1. TR-01 (TC-01)
- TP: TP-01
    1. lépés: Beírtam felhasználónévnek a "user2" stringet, jelszó helyére a "user2" stringet, jelszó ismét helyére a "user2" stringet, email cím helyére a "user@user" stringet, születési dátumnak pedig a 2000-02-02 dátumot és rámentem a Regisztráció gombra.
    2. lépés: Kiíródott alul, hogy "Sikeres regisztráció"

#### 3.1.2. TR-02 (TC-01)
- TP: TP-01
    1. lépés: Nem írtam be felhasználónevet, jelszó helyére a "user2" stringet, jelszó helyére a "user2" stringet, jelszó ismét helyére a "user2" stringet, email cím helyére a "user@user" stringet, születési dátumnak pedig a 2000-02-02 dátumot és rámentem a Regisztráció gombra.
    2. lépés: Kiíródott alul, hogy "Sikertelen"

#### 3.1.3. TR-03 (TC-01)
- TP: TP-01
    1. lépés: Beírtam felhasználónévnek a "user2" stringet, jelszó helyére nem írtam semmit, jelszó ismét helyére a "user2" stringet, email cím helyére a "user@user" stringet, születési dátumnak pedig a 2000-02-02 dátumot és rámentem a Regisztráció gombra.
    2. lépés: Kiíródott alul, hogy "Sikertelen"
    
#### 3.1.4. TR-04 (TC-01)
- TP: TP-01
    1. lépés: Beírtam felhasználónévnek a "user2" stringet, jelszó helyére a "user2" stringet, jelszó ismét helyére nem írtam semmit, email cím helyére a "user@user" stringet, születési dátumnak pedig a 2000-02-02 dátumot és rámentem a Regisztráció gombra.
    2. lépés: Kiíródott alul, hogy "Sikertelen"

#### 3.1.5. TR-05 (TC-01)
- TP: TP-01
    1. lépés: Beírtam felhasználónévnek a "user2" stringet, jelszó helyére a "user2" stringet, jelszó ismét helyére a "user2" stringet, email cím helyére nem írtam semmit, születési dátumnak pedig a 2000-02-02 dátumot és rámentem a Regisztráció gombra.
    2. lépés: Kiíródott alul, hogy "Sikertelen"

#### 3.1.6. TR-06 (TC-01)
- TP: TP-01
    1. lépés: Beírtam felhasználónévnek a "user2" stringet, jelszó helyére a "user2" stringet, jelszó ismét helyére a "user2" stringet, email cím helyére a "user@user" stringet, születési dátumnak nem írtam semmit és rámentem a Regisztráció gombra.
    2. lépés: Kiíródott alul, hogy "Sikertelen"

#### 3.1.7. TR-07 (TC-01)
- TP: TP-01
    1. lépés: Beírtam felhasználónévnek a "user2" stringet, jelszó helyére a "user2" stringet, jelszó ismét helyére a "admin2" stringet, email cím helyére a "user@user" stringet, születési dátumnak pedig a 2000-02-02 dátumot és rámentem a Regisztráció gombra.
    2. lépés: Kiíródott alul, hogy "Sikertelen"

#### 3.1.8. TR-08 (TC-01)
- TP: TP-01
    1. lépés: Beírtam felhasználónévnek a "user2" stringet, jelszó helyére a "user2" stringet, jelszó ismét helyére a "user2" stringet, email cím helyére a "user@user" stringet, születési dátumnak pedig a 2000.02.02 dátumot és rámentem a Regisztráció gombra.
    2. lépés: Kiíródott alul, hogy "Sikertelen"

#### 3.1.9. TR-09 (TC-01)
- TP: TP-01
    1. lépés: Beírtam felhasználónévnek a "user2" stringet, jelszó helyére a "user2" stringet, jelszó ismét helyére a "user2" stringet, email cím helyére a "user" stringet, születési dátumnak pedig a 2000-02-02 dátumot és rámentem a Regisztráció gombra.
    2. lépés: Kiíródott alul, hogy "Sikertelen"

### 3.2. Bejelentkezés tesztriportjai

#### 3.2.1. TR-01 (TC-02)
- TP: TP-02
    1. lépés: A bejelentkezés oldalán beírtam a felhasználónév imputjánál a "user2" stringet, a jelszónál a "user2" stringet, majd rámentem a Bejelentkezés gombra.
    2. lépés: Átkerültem a főoldalra, azaz a bejelentkezés sikeres volt.
    
#### 3.2.2. TR-02 (TC-02)
- TP: TP-02
    1. lépés: A bejelentkezés oldalán a felhasználónévhez nem írtam be semmit, a jelszónál a "user2" stringet, majd rámentem a Bejelentkezés gombra.
    2. lépés: Kiírta a felhasználónév mezőjénél, hogy "Töltse ki ezt a mezőt!"
    
#### 3.2.3. TR-03 (TC-02)
- TP: TP-02
    1. lépés: A bejelentkezés oldalán beírtam a felhasználónév imputjánál a "user2" stringet, a jelszónál nem adtam meg semmit, majd rámentem a Bejelentkezés gombra.
    2. lépés: Kiírta a jelszó mezőjénél, hogy "Töltse ki ezt a mezőt!"
    
#### 3.2.4. TR-04 (TC-02)
- TP: TP-02
    1. lépés: A bejelentkezés oldalán beírtam a felhasználónév imputjánál a "user3" stringet, a jelszónál a "user2" stringet, majd rámentem a Bejelentkezés gombra.
    2. lépés: Nem volt sikeres, hiszen nem dobott át a főoldalra.

#### 3.2.5. TR-05 (TC-02)
- TP: TP-02
    1. lépés: A bejelentkezés oldalán beírtam a felhasználónév imputjánál a "user2" stringet, a jelszónál a "user3" stringet, majd rámentem a Bejelentkezés gombra.
    2. lépés: Nem volt sikeres, hiszen nem dobott át a főoldalra.