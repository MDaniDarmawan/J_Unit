//deklarasi nama package
package com.example.unit_test

import org.junit.Test

class CalculatorTest {

    //deklarasi variabel calculator yang merupakan objek dari kelas calculatortest
    val calculator = Calculator()

    //untuk memberitahu kepada kerangka pengujian bahwasannya metode ini harus dijalankan sebagai tes
    @Test
    fun testAddSuccess(){
        val result = calculator.add(10, 10)
    }

    //sama dengan yang diatasnya yaitu untuk memberitahu kepada kerangka pengujian bahwasannya metode ini harus dijalankan sebagai tes
    @Test
    fun testAddSuccess2(){
        val result = calculator.add(10, 10)
    }
}