kunciJawaban = {"Apa nama bagian jalan yang dibuat sebagai tempat penyebrangan orang?": "zebra cross", 
                "Yuan adalah mata uang dari negara?": "Cina", 
                "Perusahaan teknologi yang membuat Iphone?": "Apple", 
                "Apa nama buah yang digunakan sebagai bahan baku minyak goreng?": "sawit", 
                "Nama energi yang berupa uap panas dari dalam bumi, biasa digunakan untuk menghasilkan listrik?": "panas bumi"}

benar = 0 # Variable untuk menyimpan jawaban benar
soal = 0 # Variable untuk menyimpan berapa banyak pertanyaan yang sudah ditampilkan

print("Selamat Datang di Quiz Umum")
print("Silahkan menjawab 5 pertanyaan di bawah ini\n")

# Looping untuk menampilkan pertanyaan serta menerima dan memverifikasi jawaban dari user
for i in kunciJawaban:
    print(f"Pertanyaan {soal+1}: {i}")
    jawaban = input("Jawaban: ").lower().strip()

    if jawaban == kunciJawaban.get(i).lower():
        print("✅ Jawaban benar!\n")
        benar += 1
    else:
        print(f"❌Jawaban salah! Jawaban yang benar adalah {kunciJawaban.get(i)}\n")

    soal += 1

# Print skor
print(f"Skor akhir anda: {benar} dari {soal}")


