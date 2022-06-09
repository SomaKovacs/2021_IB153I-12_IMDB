# Tesztjegyzõkönyv - Értékelések kezelésének tesztelése Swaggerel

Az alábbi tesztdokumentum a IMDB projekthez tartozó 9.4.7. Értékelések kezelésének tesztelése (TP, TC, TR) funkcióihoz készült. 
Felelõse: Szeles Benjámin

## 1. Teszteljárások (TP)

### 1.1. Listázás funkció tesztelése 
- Azonosító: TP-01
- Tesztesetek: TC-01
- Leírás: listázás funkció tesztelése
    0. lépés: Swaggerben a megfelelõ funkció betöltése: /rating/list
    1. lépés: Ellenõrizzük az eredményt. Elvárt eredmény: Megfelelõen betöltõdik az értékelések listája
    
### 1.2. Értékelés hozzáadásának tesztelése
- Azonosító: TP-02
- Tesztesetek: TC-01 - TC-03
- Leírás: Értékelés hozzáadásának tesztelése
    0. lépés: Swaggerben a megfelelõ funkció betöltése: /rating save
    1. lépés: Értékelés hozzáadása választott filmhez.
    2. lépés: Ellenõrizzük az eredményt. Elvárt eredmény: Az értékelés a listához hozzáadásra került.
    
### 1.3. Értékelés módosításának tesztelése
- Azonosító: TP-03
- Tesztesetek: TC-01
- Leírás: Értékelés módosításának tesztelése
    0. lépés: Swaggerben a megfelelõ funkció betöltése: /rating update
    1. lépés: Egy meglévõ értékelés kiválasztása és módosítása.
    2. lépés: Ellenõrizzük az eredményt. Elvárt eredmény: Az értékelések listájában a megváltoztatott értékelés módosul.

### 1.4. Értékelés törlésének tesztelése
- Azonosító: TP-04
- Tesztesetek: TC-01, TC-02
- Leírás: Értékelés módosításának tesztelése
    0. lépés: Swaggerben a megfelelõ funkció betöltése: /rating delete
    1. lépés: Egy meglévõ értékelés kiválasztása törlése
    2. lépés: Ellenõrizzük az eredményt. Elvárt eredmény: Az értékelések listájában az adott értékelés törlésre kerül.

## 2. Teszesetek (TC)

### 2.1.  Listázás funkció tesztelése

#### 2.1.1. TC-01
- TP: TP-01
- Leírás: Listázás funkció tesztelése
- Mûvelet: /ratings/list funkció betöltése 
- Elvárt kimenet: Az értékelések megfelelõen betöltõdnek, hiba nélkül lefut az eljárás.

### 2.2.  Értékelés hozzáadásának tesztelése

#### 2.2.1. TC-01
- TP: TP-02
- Leírás: Értékelés hozzáadásának tesztelése
- Mûvelet: /ratings save segítségével értékelés hozzáadása, majd /ratings/list segítségével ellenõrizni hogy az értékelés hozzáadasára került.
- Elvárt kimenet: Az értékelés hiba nélkül hozzáadásra került, az értékelések listájában megjelent.

#### 2.2.2. TC-02
- TP: TP-02
- Leírás: Értékelés hozzáadásának tesztelése
- Mûvelet: /ratings save segítségével értékelés hozzáadása egy nem létezõ filmhez, majd /ratings/list segítségével ellenõrizni hogy az értékelés hozzáadasára került.
- Elvárt kimenet: Az értékelés hozzáadásakor a rendszer hibát ad vissza.

#### 2.2.2. TC-03
- TP: TP-02
- Leírás: Értékelés hozzáadásának tesztelése
- Mûvelet: /ratings save segítségével értékelés hozzáadása egy nem létezõ felhasználó nevében, majd /ratings/list segítségével ellenõrizni hogy az értékelés hozzáadasára került.
- Elvárt kimenet: Az értékelés hozzáadásakor a rendszer hibát ad vissza.
### 2.3.  Értékelés módosításának tesztelése

### 2.3.  Értékelés módosításának tesztelése

#### 2.3.1. TC-01
- TP: TP-03
- Leírás: Értékelés módosításának tesztelése
- Mûvelet: /ratings update segítségével meglévõ értékelés módosítása, majd /ratings/list segítségével ellenõrizni hogy az értékelés módosításra került.
- Elvárt kimenet: Az értékelés hiba nélkül módosításra került, az értékelések listájában a változtatás megjelent.

#### 2.3.1. TC-02
- TP: TP-03
- Leírás: Értékelés módosításának tesztelése
- Mûvelet: /ratings update segítségével nem létezõ értékelés módosítása, majd /ratings/list segítségével ellenõrizni hogy az értékelés módosításra került.
- Elvárt kimenet: Az értékelés módosításakor a rendszer hibát ad vissza.

### 2.4.  Értékelés törlésének tesztelése

#### 2.4.1. TC-01
- TP: TP-04
- Leírás: Értékelés törlésének tesztelése
- Mûvelet: /ratings delete segítségével egy létezõ értékelés törlése, majd /ratings/list segítségével ellenõrzése.
- Elvárt kimenet: Az értékelés a listából eltávolításra került.

#### 2.4.1. TC-02
- TP: TP-04
- Leírás: Értékelés törlésének tesztelése
- Mûvelet: /ratings delete segítségével egy nem létezõ értékelés törlése, majd /ratings/list segítségével ellenõrzése.
- Elvárt kimenet: Az értékelés törlésekor a rendszer hibát dob vissza.

## 3. Tesztriportok (TR)

### 3.1. Listázás funkció tesztriportjai

#### 3.1.1. TR-01 (TC-01)
- TP: TP-01
    1. lépés: Megvártam amíg a funkció betöltõdik.
    2. lépés: Az elvárt eredményt kaptam.
    
    
### 3.2. Hozzáadás funkció tesztriportjai

#### 3.2.1. TR-01 (TC-01)
- TP: TP-02
    1. lépés: A /ratings save-el hozzáadtam egy új értékelést, majd a listában ellenõriztem.
    2. lépés: Az elvárt eredményt kaptam, megfelelõen megjelent az új értékelés.
    
#### 3.2.2. TR-02 (TC-02)
- TP: TP-02
    1. lépés: A /ratings save-el hozzáadtam egy új értékelést egy nem létezõ filmhez.
    2. lépés: Az elvárt eredményt kaptam, az értékelés hozzáadásakor 500-as hibát adott vissza.

#### 3.2.2. TR-02 (TC-03)
- TP: TP-02
    1. lépés: A /ratings save-el hozzáadtam egy új értékelést egy nem létezõ felhasználó nevében.
    2. lépés: Az elvárt eredményt kaptam, az értékelés hozzáadásakor 500-as hibát adott vissza.
    
### 3.3. Módosítás funkció tesztelése

#### 3.3.1. TR-01 (TC-01)
- TP: TP-03
    1. lépés: /ratings update segítségével kiválasztottam egy értékelést, és módosítottam a csillagok számát, majd a listában ellenõriztem.
    2. lépés: Az elvárt eredményt kaptam, a csillagok száma megváltoztatásra került.
    
#### 3.3.2. TR-02 (TC-02)
- TP: TP-03
    1. lépés: /ratings update segítségével kiválasztottam egy értékelést, és módosítottam a csillagok számát, majd a listában ellenõriztem.
    2. lépés: Az elvárt eredményt kaptam, az értékelés módosításakor 404-as hibát adott vissza.
    
### 3.4. Törlés funkció tesztelése

#### 3.4.1. TR-01 (TC-01)
- TP: TP-04
    1. lépés: /ratings delete segítségével töröltem egy létezõ értékelést, majd a listában ellenõriztem.
    2. lépés: Az elvárt eredményt kaptam, az értékelés törlésre került.
    
#### 3.4.2. TR-02 (TC-02)
- TP: TP-04
    1. lépés: /ratings update segítségével töröltem egy nem létezõ értékelést.
    2. lépés: Az elvárt eredményt kaptam, az értékelés törlésekor 500-as hibát adott vissza.
