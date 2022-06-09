# Tesztjegyzőkönyv-`Filmek kezelése`

Az alábbi tesztdokumentum a `IMDB` projekthez tartozó `9.4.5. Filmek kezelésének tesztelése (TP, TC, TR)` funkcióihoz készült. 
Felelőse: `Brusznyiczky Ákos` 


## 1. Teszteljárások (TP)

### 1.1. Listázás funkció tesztelése
- Azonosító: TP-01
- Tesztesetek: TC-01
- Leírás: összeadás funkció tesztelése
    0. lépés: Nyissuk meg az filmek oldalát
    1. lépés: Várjuk meg ameddig betöltődik az oldal
    2. lépés: Ellenőrizzük az eredményt. Elvárt eredmény: `Megfelelően betőltődnek a filmek`
    
### 1.2. Oldalváltás funkció tesztelése
- Azonosító: TP-02
- Tesztesetek: TC-01, TC-02
- Leírás: összeadás funkció tesztelése
    0. lépés: Nyissuk meg az filmek oldalát
    1. lépés: Várjuk meg ameddig betöltődik az oldal, görgessünk le az aljára és kattintsunk az oldalválasztó gombok egyikére
    2. lépés: Ellenőrizzük az eredményt. Elvárt eredmény: `Megfelelően betöltődik a kiválasztott oldal`
    
### 1.3. Adott film megjelenítése funkció tesztelése
- Azonosító: TP-03
- Tesztesetek: TC-01 - TC-03
- Leírás: összeadás funkció tesztelése
    0. lépés: Nyissuk meg az filmek oldalát
    1. lépés: Várjuk meg ameddig betöltődik az oldal, kattintsunk az egyik filmre
    2. lépés: Ellenőrizzük az eredményt. Elvárt eredmény: `Megjelennek a kiválasztott film adatai egy új oldalon.`

## 2. Teszesetek (TC)

### 2.1.  Listázás funkció tesztelése

#### 2.1.1. TC-01
- TP: TP-01
- Leírás: Listázás funkció tesztelése
- Művelet: Várjuk meg ameddig betöltődik az oldal 
- Elvárt kimenet: A filmek betöltődnek, alattuk megfelelően megjelenik az oldalválasztó

### 2.2.  Oldalváltás funkció tesztelése

#### 2.2.1. TC-01
- TP: TP-02
- Leírás: Oldalváltás funkció tesztelése
- Művelet: Várjuk meg ameddig betöltődik az első oldal, görgessünk le az aljára és kattintsunk az oldalválasztó gombok közül a másodikra
- Elvárt kimenet: A filmek betöltődnek, alattuk megfelelően megjelenik az oldalválasztó

#### 2.2.2. TC-02
- TP: TP-02
- Leírás: Oldalváltás funkció tesztelése
- Művelet: Várjuk meg ameddig betöltődik az utolsó oldal, görgessünk le az aljára és kattintsunk az oldalválasztó gombok közül az elsőre
- Elvárt kimenet: A filmek betöltődnek, alattuk megfelelően megjelenik az oldalválasztó

### 2.3.  Adott film megjelenítése funkció tesztelése

#### 2.3.1. TC-01
- TP: TP-03
- Leírás: Adott film megjelenítése funkció tesztelése
- Művelet: Várjuk meg ameddig betöltődik az oldal, kattintsunk az első filmre
- Elvárt kimenet: Megjelennek a kiválasztott film adatai egy új oldalon.

#### 2.3.1. TC-02
- TP: TP-03
- Leírás: Adott film megjelenítése funkció tesztelése
- Művelet: Várjuk meg ameddig betöltődik az oldal, kattintsunk az tizedik filmre
- Elvárt kimenet: Megjelennek a kiválasztott film adatai egy új oldalon.

#### 2.3.1. TC-03
- TP: TP-03
- Leírás: Adott film megjelenítése funkció tesztelése
- Művelet: Várjuk meg ameddig betöltődik az oldal, kattintsunk az hatodik filmre
- Elvárt kimenet: Megjelennek a kiválasztott film adatai egy új oldalon.

## 3. Tesztriportok (TR)

### 3.1. Listázás funkció tesztriportjai

#### 3.1.1. TR-01 (TC-01)
- TP: TP-01
    1. lépés: Megvártam ameddig betöltődik az oldal
    2. lépés: Az elvárt eredményt kaptam
    
    
### 3.2. Oldalváltás funkció tesztriportjai

#### 3.2.1. TR-01 (TC-01)
- TP: TP-02
    1. lépés: Az első oldalra érkezve megvártam, hogy betöltődjön az oldal, rákattintottam a 2.-oldal gombjára.
    2. lépés: Az elvárt eredményt kaptam, megfelelően megjelent a kiválasztott oldal
    
#### 3.2.2. TR-02 (TC-02)
- TP: TP-02
    1. lépés: Az utolsó oldalra érkezve megvártam, hogy betöltődjön az oldal, rákattintottam a 1.-oldal gombjára.
    2. lépés: Az elvárt eredményt kaptam, megfelelően megjelent a kiválasztott oldal
    
### 3.3. Adott film megjelenítése funkció tesztelése

#### 3.3.1. TR-01 (TC-01)
- TP: TP-03
    1. lépés: Megvártam ameddig betöltődik az oldal, rákattintottam az első filmre.
    2. lépés: Az elvárt eredményt kaptam
    
#### 3.3.2. TR-02 (TC-02)
- TP: TP-03
    1. lépés: Megvártam ameddig betöltődik az oldal, rákattintottam az tizedik filmre.
    2. lépés: Az elvárt eredményt kaptam
    
#### 3.3.3. TR-03 (TC-03)
- TP: TP-03
    1. lépés: Megvártam ameddig betöltődik az oldal, rákattintottam az hatodik filmre.
    2. lépés: Az elvárt eredményt kaptam