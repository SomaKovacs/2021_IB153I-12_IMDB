# Tesztjegyz�k�nyv - �rt�kel�sek kezel�s�nek tesztel�se Swaggerel

Az al�bbi tesztdokumentum a IMDB projekthez tartoz� 9.4.7. �rt�kel�sek kezel�s�nek tesztel�se (TP, TC, TR) funkci�ihoz k�sz�lt. 
Felel�se: Szeles Benj�min

## 1. Tesztelj�r�sok (TP)

### 1.1. List�z�s funkci� tesztel�se 
- Azonos�t�: TP-01
- Tesztesetek: TC-01
- Le�r�s: list�z�s funkci� tesztel�se
    0. l�p�s: Swaggerben a megfelel� funkci� bet�lt�se: /rating/list
    1. l�p�s: Ellen�rizz�k az eredm�nyt. Elv�rt eredm�ny: Megfelel�en bet�lt�dik az �rt�kel�sek list�ja
    
### 1.2. �rt�kel�s hozz�ad�s�nak tesztel�se
- Azonos�t�: TP-02
- Tesztesetek: TC-01 - TC-03
- Le�r�s: �rt�kel�s hozz�ad�s�nak tesztel�se
    0. l�p�s: Swaggerben a megfelel� funkci� bet�lt�se: /rating save
    1. l�p�s: �rt�kel�s hozz�ad�sa v�lasztott filmhez.
    2. l�p�s: Ellen�rizz�k az eredm�nyt. Elv�rt eredm�ny: Az �rt�kel�s a list�hoz hozz�ad�sra ker�lt.
    
### 1.3. �rt�kel�s m�dos�t�s�nak tesztel�se
- Azonos�t�: TP-03
- Tesztesetek: TC-01
- Le�r�s: �rt�kel�s m�dos�t�s�nak tesztel�se
    0. l�p�s: Swaggerben a megfelel� funkci� bet�lt�se: /rating update
    1. l�p�s: Egy megl�v� �rt�kel�s kiv�laszt�sa �s m�dos�t�sa.
    2. l�p�s: Ellen�rizz�k az eredm�nyt. Elv�rt eredm�ny: Az �rt�kel�sek list�j�ban a megv�ltoztatott �rt�kel�s m�dosul.

### 1.4. �rt�kel�s t�rl�s�nek tesztel�se
- Azonos�t�: TP-04
- Tesztesetek: TC-01, TC-02
- Le�r�s: �rt�kel�s m�dos�t�s�nak tesztel�se
    0. l�p�s: Swaggerben a megfelel� funkci� bet�lt�se: /rating delete
    1. l�p�s: Egy megl�v� �rt�kel�s kiv�laszt�sa t�rl�se
    2. l�p�s: Ellen�rizz�k az eredm�nyt. Elv�rt eredm�ny: Az �rt�kel�sek list�j�ban az adott �rt�kel�s t�rl�sre ker�l.

## 2. Teszesetek (TC)

### 2.1.  List�z�s funkci� tesztel�se

#### 2.1.1. TC-01
- TP: TP-01
- Le�r�s: List�z�s funkci� tesztel�se
- M�velet: /ratings/list funkci� bet�lt�se 
- Elv�rt kimenet: Az �rt�kel�sek megfelel�en bet�lt�dnek, hiba n�lk�l lefut az elj�r�s.

### 2.2.  �rt�kel�s hozz�ad�s�nak tesztel�se

#### 2.2.1. TC-01
- TP: TP-02
- Le�r�s: �rt�kel�s hozz�ad�s�nak tesztel�se
- M�velet: /ratings save seg�ts�g�vel �rt�kel�s hozz�ad�sa, majd /ratings/list seg�ts�g�vel ellen�rizni hogy az �rt�kel�s hozz�adas�ra ker�lt.
- Elv�rt kimenet: Az �rt�kel�s hiba n�lk�l hozz�ad�sra ker�lt, az �rt�kel�sek list�j�ban megjelent.

#### 2.2.2. TC-02
- TP: TP-02
- Le�r�s: �rt�kel�s hozz�ad�s�nak tesztel�se
- M�velet: /ratings save seg�ts�g�vel �rt�kel�s hozz�ad�sa egy nem l�tez� filmhez, majd /ratings/list seg�ts�g�vel ellen�rizni hogy az �rt�kel�s hozz�adas�ra ker�lt.
- Elv�rt kimenet: Az �rt�kel�s hozz�ad�sakor a rendszer hib�t ad vissza.

#### 2.2.2. TC-03
- TP: TP-02
- Le�r�s: �rt�kel�s hozz�ad�s�nak tesztel�se
- M�velet: /ratings save seg�ts�g�vel �rt�kel�s hozz�ad�sa egy nem l�tez� felhaszn�l� nev�ben, majd /ratings/list seg�ts�g�vel ellen�rizni hogy az �rt�kel�s hozz�adas�ra ker�lt.
- Elv�rt kimenet: Az �rt�kel�s hozz�ad�sakor a rendszer hib�t ad vissza.
### 2.3.  �rt�kel�s m�dos�t�s�nak tesztel�se

### 2.3.  �rt�kel�s m�dos�t�s�nak tesztel�se

#### 2.3.1. TC-01
- TP: TP-03
- Le�r�s: �rt�kel�s m�dos�t�s�nak tesztel�se
- M�velet: /ratings update seg�ts�g�vel megl�v� �rt�kel�s m�dos�t�sa, majd /ratings/list seg�ts�g�vel ellen�rizni hogy az �rt�kel�s m�dos�t�sra ker�lt.
- Elv�rt kimenet: Az �rt�kel�s hiba n�lk�l m�dos�t�sra ker�lt, az �rt�kel�sek list�j�ban a v�ltoztat�s megjelent.

#### 2.3.1. TC-02
- TP: TP-03
- Le�r�s: �rt�kel�s m�dos�t�s�nak tesztel�se
- M�velet: /ratings update seg�ts�g�vel nem l�tez� �rt�kel�s m�dos�t�sa, majd /ratings/list seg�ts�g�vel ellen�rizni hogy az �rt�kel�s m�dos�t�sra ker�lt.
- Elv�rt kimenet: Az �rt�kel�s m�dos�t�sakor a rendszer hib�t ad vissza.

### 2.4.  �rt�kel�s t�rl�s�nek tesztel�se

#### 2.4.1. TC-01
- TP: TP-04
- Le�r�s: �rt�kel�s t�rl�s�nek tesztel�se
- M�velet: /ratings delete seg�ts�g�vel egy l�tez� �rt�kel�s t�rl�se, majd /ratings/list seg�ts�g�vel ellen�rz�se.
- Elv�rt kimenet: Az �rt�kel�s a list�b�l elt�vol�t�sra ker�lt.

#### 2.4.1. TC-02
- TP: TP-04
- Le�r�s: �rt�kel�s t�rl�s�nek tesztel�se
- M�velet: /ratings delete seg�ts�g�vel egy nem l�tez� �rt�kel�s t�rl�se, majd /ratings/list seg�ts�g�vel ellen�rz�se.
- Elv�rt kimenet: Az �rt�kel�s t�rl�sekor a rendszer hib�t dob vissza.

## 3. Tesztriportok (TR)

### 3.1. List�z�s funkci� tesztriportjai

#### 3.1.1. TR-01 (TC-01)
- TP: TP-01
    1. l�p�s: Megv�rtam am�g a funkci� bet�lt�dik.
    2. l�p�s: Az elv�rt eredm�nyt kaptam.
    
    
### 3.2. Hozz�ad�s funkci� tesztriportjai

#### 3.2.1. TR-01 (TC-01)
- TP: TP-02
    1. l�p�s: A /ratings save-el hozz�adtam egy �j �rt�kel�st, majd a list�ban ellen�riztem.
    2. l�p�s: Az elv�rt eredm�nyt kaptam, megfelel�en megjelent az �j �rt�kel�s.
    
#### 3.2.2. TR-02 (TC-02)
- TP: TP-02
    1. l�p�s: A /ratings save-el hozz�adtam egy �j �rt�kel�st egy nem l�tez� filmhez.
    2. l�p�s: Az elv�rt eredm�nyt kaptam, az �rt�kel�s hozz�ad�sakor 500-as hib�t adott vissza.

#### 3.2.2. TR-02 (TC-03)
- TP: TP-02
    1. l�p�s: A /ratings save-el hozz�adtam egy �j �rt�kel�st egy nem l�tez� felhaszn�l� nev�ben.
    2. l�p�s: Az elv�rt eredm�nyt kaptam, az �rt�kel�s hozz�ad�sakor 500-as hib�t adott vissza.
    
### 3.3. M�dos�t�s funkci� tesztel�se

#### 3.3.1. TR-01 (TC-01)
- TP: TP-03
    1. l�p�s: /ratings update seg�ts�g�vel kiv�lasztottam egy �rt�kel�st, �s m�dos�tottam a csillagok sz�m�t, majd a list�ban ellen�riztem.
    2. l�p�s: Az elv�rt eredm�nyt kaptam, a csillagok sz�ma megv�ltoztat�sra ker�lt.
    
#### 3.3.2. TR-02 (TC-02)
- TP: TP-03
    1. l�p�s: /ratings update seg�ts�g�vel kiv�lasztottam egy �rt�kel�st, �s m�dos�tottam a csillagok sz�m�t, majd a list�ban ellen�riztem.
    2. l�p�s: Az elv�rt eredm�nyt kaptam, az �rt�kel�s m�dos�t�sakor 404-as hib�t adott vissza.
    
### 3.4. T�rl�s funkci� tesztel�se

#### 3.4.1. TR-01 (TC-01)
- TP: TP-04
    1. l�p�s: /ratings delete seg�ts�g�vel t�r�ltem egy l�tez� �rt�kel�st, majd a list�ban ellen�riztem.
    2. l�p�s: Az elv�rt eredm�nyt kaptam, az �rt�kel�s t�rl�sre ker�lt.
    
#### 3.4.2. TR-02 (TC-02)
- TP: TP-04
    1. l�p�s: /ratings update seg�ts�g�vel t�r�ltem egy nem l�tez� �rt�kel�st.
    2. l�p�s: Az elv�rt eredm�nyt kaptam, az �rt�kel�s t�rl�sekor 500-as hib�t adott vissza.
