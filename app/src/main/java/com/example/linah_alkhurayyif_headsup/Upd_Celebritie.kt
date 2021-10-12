package com.example.linah_alkhurayyif_headsup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_upd_celebritie.*
import retrofit2.Call
import retrofit2.Response
import retrofit2.Callback

class Upd_Celebritie : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_upd_celebritie)
        var Celebritie_Id = intent.extras?.getInt("Celebritie_Id")!!
        var Celebritie_Name =intent.extras?.getString("Celebritie_Name")!!
        var Taboo1 =intent.extras?.getString("Taboo1")!!
        var Taboo2 =intent.extras?.getString("Taboo2")!!
        var Taboo3 =intent.extras?.getString("Taboo3")!!

        UCelebritie_id.text = "Celebrity ${Celebritie_Id}"
        UName.hint = Celebritie_Name
        UTaboo1.hint = Taboo1
        UTaboo2.hint = Taboo2
        UTaboo3.hint = Taboo3
        val apiInterface = APIClient().getClient()?.create(APIInterface::class.java)
        babkbtn.setOnClickListener {
            intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
        }
        Usavebtn.setOnClickListener {
            var CelebritieName =Celebritie_Name
            var Taboo_1 =Taboo1
            var Taboo_2 =Taboo2
            var Taboo_3 =Taboo3
            if(UName.text.toString() != ""){
                CelebritieName=UName.text.toString()
            }
            if(UTaboo1.text.toString() != ""){
                Taboo_1= UTaboo1.text.toString()
            }
            if(UTaboo2.text.toString() != ""){
                Taboo_2= UTaboo2.text.toString()
            }
            if(UTaboo3.text.toString() != ""){
                Taboo_3= UTaboo3.text.toString()
            }
            apiInterface?.updatecelebrities(Celebritie_Id,CelebritiesDetails.Celebrities(CelebritieName,Taboo_1,Taboo_2,Taboo_3,Celebritie_Id))?.enqueue(object:
                Callback<CelebritiesDetails.Celebrities> {
                override fun onResponse(
                    call: Call<CelebritiesDetails.Celebrities>,
                    response: Response<CelebritiesDetails.Celebrities>
                ) {
                    Toast.makeText(applicationContext, "Update Success!", Toast.LENGTH_SHORT).show()
                    nextPage()
                }

                override fun onFailure(call: Call<CelebritiesDetails.Celebrities>, t: Throwable) {
                    Toast.makeText(applicationContext, ""+t.message, Toast.LENGTH_SHORT).show()
                }
            })

        }
    }
    private fun nextPage(){

        intent = Intent(applicationContext, MainActivity::class.java)
        startActivity(intent)
    }
}