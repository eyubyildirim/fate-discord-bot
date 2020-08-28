# FateBot
Fate zarlarını atmayı kolaylaştıran bir Discord botu.

# Discord botu oluşturmak

1. https://discord.com/developers/applications adresine gidin
2. **New Application** tuşuna tıklayın
3. İsmini verip botu oluşturun
4. Sol taraftan **Bot** sekmesine girin
5. **Add Bot** tuşuna basarak botu oluşturun
6. Bu sekmedeki token ve **General Information** sekmesindeki Client ID bize ileride lazım olacak, not defterine not alabilirsiniz
7. **OAuth2** sekmesine tıklayın
8. **Scopes** bölümü altında bot seçeneğini işaretleyin, aşağıda bir link ve **Bot Permissions** adında bir bölüm daha oluşacak
9. Yeni bölümden hemen sol üstte bulunan **Administrator** seçeneğini işaretleyip linki kopyalayın
10. Linki kullanarak botu sunucunuza ekleyebilirsiniz

# Botu çalıştırmak

Eğer Java ile aşinalığınız varsa ve bilgisayarınızda bir IDE yüklüyse bu repository'i klonlayıp doğrudan çalıştırabilirsiniz.
Tek yapmanız gereken program argümanlarına oluşturduğunuz Discord botunun token ve client ID'sini, önce ID sonra token gelecek şekilde eklemek.

Eğer herhangi bir IDE sahibi değilseniz;
1. Önce bilgisayarınızda yüklü değilse Java'yı yükleyin
2. Proje dosyalarından discord-bot.jar dosyasını indirin
3. İndirdiğiniz yerde bir CMD ya da PowerShell (Mac ve Linux'ta terminal) açın
4. java -jar discord-bot.jar clientId token komutunu kullanın
5. Eğer id ya da tokeni yanlış yazarsanız bot çalışmayacaktır.

Bunun dışında botu çalıştırmada herhangi bir sorun yaşarsanız bana Discord üzerinden ulaşabilirsiniz.

Eğer botu çalıştırdıysanız, botu eklediğiniz sunuculardan birinde kullanabilirsiniz.

# Botu kullanmak

Bot sadece tek bir komuta sahip, bu komut '?diceroll' komutu.

Komutu kullandığınız zaman bot bir embed mesaj oluşturacak. Bu mesajın altındaki emojileri kullanarak attığınız zara kaç eklemek istediğinizi belirtebilirsiniz.

Karşılaştığınız sorunları ve eklenmesini istediğiniz özellikleri bu repository'e ekleyebilir ya da doğrudan bana Discord üzerinden iletebilirsiniz.