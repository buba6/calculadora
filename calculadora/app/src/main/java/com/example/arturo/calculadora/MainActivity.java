package com.example.arturo.calculadora;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private  EditText Scr;
    private float NumberBf;
    private String Operation;
    private ButtonClickListener btnClick;

    private TextView resultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Scr = (EditText) findViewById(R.id.editar);
        btnClick = new ButtonClickListener();

        resultado = (TextView) findViewById(R.id.editar);

        int idList[] ={R.id.button0,R.id.button,R.id.button2,R.id.button3,R.id.button4,
                R.id.button6,R.id.button7,R.id.button8,R.id.button9,R.id.button10,R.id.buttonDot,R.id.buttonborrar,
                R.id.buttonMul,R.id.buttonDiv,R.id.buttonAdd,R.id.buttonSub,R.id.buttonC,R.id.buttonEq
    };

     for(int id:idList){
        View v =(View) findViewById(id);
        v.setOnClickListener(btnClick);
     }}



    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }




    public void nMatch(String str){

        NumberBf=Float.parseFloat(Scr.getText().toString());
        Operation=str;
        Scr.setText("");
    }
public void borrar(){
    resultado.setText(resultado.getText().subSequence(0, resultado.getText().length() - 1) + "");
}
    public void getKeyboard(String str){
        String ScrCurrent=Scr.getText().toString();
        if(ScrCurrent.equals(""))
            ScrCurrent="";


        ScrCurrent +=str;
        Scr.setText(ScrCurrent);
    }

    public void nResult(){
        float NumAF=Float.parseFloat(Scr.getText().toString());
        float result=0;

        if(Operation.equals("+")){
            result= NumAF+NumberBf;

        }
        if(Operation.equals("-")){

            result=NumberBf-NumAF;
        }
        if(Operation.equals("*")){

            result=NumAF*NumberBf;
        }
        if(Operation.equals("/")){

            result=NumberBf/NumAF;
        }
        Scr.setText(String.valueOf(result));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
        private class ButtonClickListener implements View.OnClickListener {
            public  void onClick(View v){
                try{
            switch (v.getId()) {


                case R.id.buttonC:
                    Scr.setText("");
                    NumberBf = 0;
                    Operation = "";
                    break;
                case R.id.buttonAdd:
                    nMatch("+");
                    break;
                case R.id.buttonSub:
                    nMatch("-");
                    break;
                case R.id.buttonMul:
                    nMatch("*");
                    break;
                case R.id.buttonDiv:
                    nMatch("/");
                    break;
                case R.id.buttonEq:
                    nResult();
                    break;
                case R.id.buttonborrar:


                    borrar();

                    break;
                default:
                    String numb = ((Button) v).getText().toString();
                    getKeyboard(numb);
                    break;
            }
            } catch (Exception e){
                    Toast.makeText(getApplicationContext(), "error", Toast.LENGTH_SHORT).show();
                };

            }


            }

        }


