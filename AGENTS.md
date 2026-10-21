# AGENTS.md — Turizam (Lab 1)

Uputstvo za člana tima i za AI u IDE-u nakon `git clone`.
Projekat je namjerno jednostavan: MVC, in-memory podaci, bez baze, bez servis/repository sloja.

## Šta je ovo

Mini MVC Spring Boot aplikacija, tema **Turizam: Destination & Tour**.

- Spring Boot 4.1.1, Java 21, Thymeleaf, Lombok
- Relacija **1:N**: jedna destinacija ima više tura
- Akcija: GET `/a/action/{id}` uveća `bookings` na destinaciji i prikaže `action.html`

## Pokretanje

IntelliJ: otvori ovaj folder (onaj sa `pom.xml`) kao Maven projekat, JDK 21, Run na `DemoApplication`.

Ili u terminalu:

```bash
./mvnw spring-boot:run
```

Na Windowsu: `.\mvnw.cmd spring-boot:run`

Zatim: http://localhost:8080/a

Rute:

- `/` → redirect na `/a`
- `/a` — lista destinacija
- `/b` — lista tura
- `/a/action/{id}` — rezervacija (bookings++)

## Pravila (ne komplikovati)

- Nema JPA, baze, Spring Data, servisa ni repositoryja
- Jedan kontroler: `AppController`
- Podaci samo u `DemoData.java`
- HTML ostaje tri Thymeleaf stranice + mali inline CSS
- Paket ostaje `com.example.demo`

## Podjela u timu

| Student | Odgovornost |
|---|---|
| A (Emir) | Model A `Destination` + ruta `/a` + `listA.html` |
| B | Model B `Tour` + ruta `/b` + `listB.html` |
| A + B | Akcija `/a/action/{id}` + `action.html` + `DemoData` |

Ime studenta B unijeti u `README.md`.

## Struktura

```
src/main/java/com/example/demo/
├─ DemoApplication.java
├─ model/
│  ├─ Destination.java
│  └─ Tour.java
├─ data/
│  └─ DemoData.java
└─ controller/
   └─ AppController.java
src/main/resources/templates/
├─ listA.html
├─ listB.html
└─ action.html
```

### Destination (Model A)

Atributi: `id`, `name`, `country`, `description`, `bookings`, `List<Tour> tours`.

Lombok: `@Data`, `@NoArgsConstructor`, `@AllArgsConstructor`.

### Tour (Model B)

Atributi: `id`, `name`, `durationDays`, `price`, `type`, `destinationName` (običan String da se relacija vidi i na `/b`).

### DemoData

Statičke liste: 3 destinacije (Sarajevo, Mostar, Dubrovnik), 6 tura.
Metode: `getDestinations()`, `getTours()`, `findDestinationById(id)`.

### AppController

```java
@GetMapping("/a")              // lista destinacija
@GetMapping("/b")              // lista tura
@GetMapping("/a/action/{id}")  // bookings++ pa action.html
```

`/` radi `redirect:/a`. Ništa više.

## Plan izrade (taskovi)

Taskovi 1–6 su urađeni. Task 7 ostaje za predaju.

### Task 1 — pom.xml (gotovo)

- `spring-boot-starter-web`
- `<name>Turizam</name>` i description

Bez web startera nema HTTP ruta.

### Task 2 — Destination.java (gotovo, Student A)

`src/main/java/com/example/demo/model/Destination.java`

### Task 3 — Tour.java (gotovo, Student B)

`src/main/java/com/example/demo/model/Tour.java`

### Task 4 — DemoData.java (gotovo, zajedno)

`src/main/java/com/example/demo/data/DemoData.java`

### Task 5 — AppController (gotovo)

`src/main/java/com/example/demo/controller/AppController.java`

Folder mora biti `controller` (jednina), da se poklopi sa paketom.

### Task 6 — HTML (gotovo)

- `listA.html` — destinacije, kolona tura, link Rezerviši → `/a/action/{id}`
- `listB.html` — ture, kolona destinacije
- `action.html` — destinacija, novi broj rezervacija, lista njenih tura

### Task 7 — predaja (ostalo)

Obavezno prije Classroom predaje:

1. `README.md` — naziv aplikacije, imena oba člana, opis modela i relacije 1:N, screenshot
2. `IZRADA.md` — logički tok kreiranja + internet izvori + napomena da je korišten ugrađeni AI u Cursor IDE
3. Screenshot aplikacije (npr. `screenshot.png` sa stranice `/a`)
4. Snimak ekrana uz projekat (obavezni dodatak)

GitHub repo mora biti public. Link predati na Classroom zadatak.

## Šta AI / drugi član smije mijenjati

- Sitni bugfix, tekst, CSS, imena u README
- Dopuna `IZRADA.md` i screenshot
- Ne dodavati bazu, security, REST API, Bootstrap, nove slojeve ili nove rute osim ako to eksplicitno zatraži lab
