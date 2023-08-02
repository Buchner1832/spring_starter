# Eine Vorlage für ein Projekt in Spring

## Installation

In der Folge wird eine Möglichkeit beschrieben, das Projekt auf einem eigenen Computer zum Laufen zu bringen. Auf einem Schulrechner kannst du das Projekt nur bearbeiten, wenn auf diesem Java bereits installiert ist. Allerdings gibt es auch die Möglichkeit, das Projekt online zu bearbeiten und auszuführen. (Wird noch ergänzt.)

Um Programme in Java entwickeln zu können benötigst du das Java Development Kit (JDK). Für dieses Projekt muss es mindestens die Version 17 sein. Wir empfehlen das JDK von der Adoptium Working Group, weil dieses frei und quelloffen ist: [https://adoptium.net/de/temurin/releases/](https://adoptium.net/de/temurin/releases/)

## Start und Test
Führe  in einer Kommandozeilenanwendung (z.B. PowerShell oder einem Terminal in VSCode) den Befehl

```
$ ./gradlew bootRun
```

aus, um die Anwendung zu übersetzen und zu starten. 
Öffne dann in einem Browser die Adresse [127.0.0.1:8080/](127.0.0.1:8080/).

 ### Was schon funktioniert

 Du kannst bei der Basisroute eine Anfrageparameter angeben:
 ```
 127.0.0.1:8080/?name=Michael
 ``` 
Du kannst beim Beim Wetter-Endpunkt den Namen einer Stadt als Pfadvariable festlegen:
```
 127.0.0.1:8080/weather/Hof
```
Beachte allerdings, dass im Moment die Variable zwar an den Server weitergegeben wird, aber aktuell immer die Temperatur von Bamberg angezeigt wird. Es könnte eine erste Aufgabe sein, dies zu ändern.


## CSS-Bibliothek Bulma
Dieses Projekt verwendet die CSS-Bibliothek Bulma: [https://bulma.io/](https://bulma.io/).
Moderne Webseiten sollten auf unterschiedlichsten Geräten mit verschiedenen Bildschirmgrößen gut angezeigt werden. Um dies zu erreichen, ist die Verwendung einer CSS-Bibliothek empfehlenswert. 


