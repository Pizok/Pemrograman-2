import tkinter as tk
from tkinter import ttk

#Fungsi sapa
def sapa():
    nama = nama_depan.get() + " " + nama_belakang.get()
    hasil.config(text=f"Hallo {nama}!")

#GUI Config
main = tk.Tk()
main.configure(bg="white")
main.geometry("500x500")
main.resizable(False, False)
main.title("Aplikasi Sapa!")

#Main frame
main_frame = ttk.Frame(main,  relief = "groove", borderwidth= 2)
main_frame.pack(anchor="center", fill="x", expand=True)

#INput nama depan
title_depan = ttk.Label(main_frame, text="Masukkan nama depan")
title_depan.pack(anchor="nw", padx= 10, pady= 5, fill="x", expand=True)

nama_depan = ttk.Entry(main_frame)
nama_depan.pack(anchor="nw", padx= 10, pady= 10, fill="x", expand=True)

#Input nama belakang
title_belakang = ttk.Label(main_frame, text="Masukkan nama belakang")
title_belakang.pack(anchor="nw", padx= 10, pady= 5, fill="x", expand=True)

nama_belakang = ttk.Entry(main_frame)
nama_belakang.pack(anchor="nw", padx= 10, pady= 10, fill="x", expand=True)

#Button submit
button = ttk.Button(main_frame, text="Sapa", command=sapa)
button.pack(anchor="nw", padx= 10, pady= 10, fill="x", expand=True)

#Label hasil
hasil = ttk.Label(main_frame)
hasil.pack(anchor="nw", padx= 10, pady= 5, fill="x", expand=True)

#Run loop
main.mainloop()

