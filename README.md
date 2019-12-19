# Projektötlet
## Funkcionális követelmények:
- Néző: 
  - Főoldalról film kiválasztása
	- Film kiválasztása után adatok megtekintése
	- Film kiválasztása után jegyfoglalás -> név, email, telefon megadása (form) -> helyválasztás
- Alkalmazott:
  -	Bejelentkezés után megjelenik az új film meghirdetésének lehetősége (film adatainak megadása) + film adatainak módosítása
  -	Jegyeladás: Lefoglalt jegy eladása -> foglalás adatainak megtekintése -> majd foglalás törlése
  -	TODO: Új előadás hozzáadása: terem kiválasztása, időpont megadása

## Nem funkcionális követelmények:
-	Felhasználóbarát, ergonomikus elrendezés és kinézet.
-	Gyors működés.
-	Biztonságos működés: jelszavak tárolása, funkciókhoz való hozzáférés.

## Szerepkörök: 
-	Néző: a főoldal tartalmához fér hozzá, rögzíteni nem tud
-	Alkalmazott: be tud jelentkezni, meg tudja hirdetni az előadásokat, illetve el tud adni jegyet

# Végpontok:

employee:  
GET /employee -> összes alkalmazott listázása  
GET /logout -> kijelentkezés  
GET /login -> bejelentkezés  

room:  
GET /room -> összes terem listázása  
GET /room/{id} -> adott terem lekérése  
GET /room/{id}/seats -> adott teremben lévő székek  
GET /room/{id}/screenings -> adott teremben lévő vetítések  

seat:  
GET /seat/{id} -> adott szék lekérése  
PUT /seat/{id} -> adott szék állapotának módosítása    

booking:  
GET /booking -> összes foglalás listázása  
GET /booking/id/{id} -> foglalás lekérése id alapján  
GET /booking/name/{name} -> foglalás lekérése név alapján  
GET /booking/id/{id}/seats -> adott foglaláshoz (id) tartozó székek  
GET /booking/name/{name}/seats -> adott foglaláshoz (név) tartozó székek  
POST /booking -> új foglalás hozzáadása  
DELETE /booking/{id} -> foglalás törlése  

movie:  
GET/movie -> összes film listázása   
GET /movie/{id} -> film lekérése id alapján    
GET /movie /{id}/screenings -> adott filmhez (id) tartozó előadások    
POST /movie -> új film hozzáadása   
DELETE /movie/{id} -> film törlése  

screening:  
GET/screening -> összes előadás listázása  
GET / screening /{id} -> előadás lekérése id alapján  
POST /screening -> új előadás hozzáadása  
PUT /screening/{id} -> előadás módosítása  
DELETE /screening/{id} -> előadás törlése  

# Adatbázis-terv: táblák kapcsolati UML diagramja
![alt text](https://github.com/p3uvid/alkfejl/blob/master/uml.png)

# Alkalmazott könyvtárstruktúra
![alt text](https://github.com/p3uvid/alkfejl/blob/master/structure.png)  

# Szekvenciadiagram:  
Az alkalmazott bejelentkezés után képes az összes előadás listázására, illetve új előadás hozzáadására is:    
![alt text](https://github.com/p3uvid/alkfejl/blob/master/sequence.PNG) 
