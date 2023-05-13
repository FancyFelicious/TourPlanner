#### Additional encryption of stored passwords in db:

serverside zusätzlich hash mit pgcrypto
CREATE EXTENSION IF NOT EXISTS pgcrypto;
CREATE EXTENSION IF NOT EXISTS "pgcrypto";
SELECT * FROM pg_extension WHERE extname = 'pgcrypto';

INSERT INTO users (username, password)
VALUES ('johndoe', crypt('password123', gen_salt('bf')));

// Add pgcrypto extension
CREATE EXTENSION IF NOT EXISTS pgcrypto;

// Confirm installation was succesful
SELECT * FROM pg_extension WHERE extname = 'pgcrypto';

// Use pgcrypto to hash pw
INSERT INTO users (username, password)
VALUES ('johndoe', crypt('password123', gen_salt('bf'))); // bf = blowfish

#### Hash / Argon2Id

https://cheatsheetseries.owasp.org/cheatsheets/Password_Storage_Cheat_Sheet.html
https://github.com/phxql/argon2-jvm
https://mkyong.com/java/java-password-hashing-with-argon2/

#### JSON Parser, fasterxml:

https://www.youtube.com/watch?v=Hv_a3ZBSO_g
https://fasterxml.github.io/jackson-annotations/javadoc/2.8/com/fasterxml/jackson/annotation/JsonProperty.html

parser.getCurrentName(); FIELD_NAME (dafür gibts JsonToken (=enum))
parser.getValueAsString();
parser.getValueAsInt();
parser.getText();

#### Convert curl request to http request (httpfile)

https://www.jetbrains.com/help/idea/http-client-in-product-code-editor.html#curl-to-http

#### Get current time/date - timestamp

https://mkyong.com/java/how-to-get-current-timestamps-in-java/

### Path to repositories / dependencies
\\wsl$\Ubuntu\home\coke\.m2\repository\

### IntelliJ Auto Save:
Tools > Action on Save > Rearrange code > Java > Rules

### Argon2:
Argon2: https://github.com/phxql/argon2-jvm