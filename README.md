# 🛠️ Plugin Minecraft pour Vérification des Séances du Code de la Route 🚗

J'ai développé un plugin Minecraft qui vérifie si les joueurs ont complété leurs séances du code de la route. Si un joueur n'a pas suffisamment de séances de code enregistrées, il ne pourra pas se connecter au serveur. Pour cette vérification, nous utilisons l'application Kopilote. Les paramètres de configuration nécessaires se trouvent dans le fichier config.yml.

## 📄 Configuration (`config.yml`)

```yaml
kopilot:
  username: "username"
  password: "password"

code:
  number: 2
  result: 25

minecraft:
  uuid: "uuid"
```
