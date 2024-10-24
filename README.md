# playwrightImageComparison
The compareImages method is designed to compare two images pixel by pixel and highlight the differences. Here's a step-by-step explanation:  
Read Images: The method reads two images from the provided file paths using ImageIO.read.
Initialize Variables: It initializes the width and height of the images and creates a new BufferedImage to store the differences.
Compare Pixels: It iterates over each pixel of the images. If the pixels differ, it marks the pixel in the diff image with red (0xFFFF0000). If they are the same, it copies the pixel from the first image.
Save Diff Image: It saves the diff image to a file named diff.png.
Attach Screenshot: If there are any differing pixels, it attaches the diff.png image to the test report.
Print Difference Count: It prints the number of differing pixels.
#################################################################
compareImages yöntemi, iki görüntüyü piksel piksel karşılaştırmak ve farklılıkları vurgulamak için tasarlanmıştır. İşte adım adım açıklaması:  
Görüntüleri Oku: Yöntem, sağlanan dosya yollarından iki görüntüyü ImageIO.read kullanarak okur.
Değişkenleri Başlat: Görüntülerin genişlik ve yüksekliklerini başlatır ve farklılıkları depolamak için yeni bir BufferedImage oluşturur.
Pikselleri Karşılaştır: Görüntülerin her pikselini iterasyonla kontrol eder. Eğer pikseller farklıysa, diff görüntüsünde pikseli kırmızı (0xFFFF0000) ile işaretler. Eğer aynıysa, pikseli ilk görüntüden kopyalar.
Fark Görüntüsünü Kaydet: diff görüntüsünü diff.png adlı bir dosyaya kaydeder.
Ekran Görüntüsünü Ekle: Farklı pikseller varsa, diff.png görüntüsünü test raporuna ekler.
Farklı Piksel Sayısını Yazdır: Farklı piksel sayısını yazdırır.
