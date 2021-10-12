package com.example.linah_alkhurayyif_headsup

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_add_celebrities.*
import retrofit2.Response

class AddCelebrities : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_celebrities)
        Abackbtn.setOnClickListener {
            intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
        }
        Asavebtn.setOnClickListener {
            if(name_et.text.toString()=="" || taboo1_et.text.toString()=="" || taboo2_et.text.toString()=="" || taboo3_et.text.toString()==""){
                Toast.makeText(applicationContext, "Can not submit empty data!!", Toast.LENGTH_SHORT).show()
            }else{
                val progressDialog = ProgressDialog(this@AddCelebrities)
                progressDialog.setMessage("Please wait")
                progressDialog.show()
                var NewCelebrities = CelebritiesDetails.Celebrities(name_et.text.toString(), taboo1_et.text.toString(), taboo2_et.text.toString(), taboo3_et.text.toString(),null)
                val apiInterface = APIClient().getClient()?.create(APIInterface::class.java)
                apiInterface!!.addcelebrities(NewCelebrities).enqueue(object : retrofit2.Callback<CelebritiesDetails.Celebrities>{
                    override fun onResponse(
                        call: retrofit2.Call<CelebritiesDetails.Celebrities>,
                        response: Response<CelebritiesDetails.Celebrities>
                    ) {
                        progressDialog.dismiss()
                        name_et.setText("")
                        taboo1_et.setText("")
                        taboo2_et.setText("")
                        taboo3_et.setText("")
                        Toast.makeText(applicationContext, "Save Success!", Toast.LENGTH_SHORT).show()
                    }

                    override fun onFailure(call: retrofit2.Call<CelebritiesDetails.Celebrities>, t: Throwable) {
                        progressDialog.dismiss()
                        Toast.makeText(applicationContext, ""+t.message, Toast.LENGTH_SHORT).show()
                    }
                })
            }}
    }}