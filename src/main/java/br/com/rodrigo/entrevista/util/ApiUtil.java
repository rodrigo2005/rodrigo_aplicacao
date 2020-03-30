package br.com.rodrigo.entrevista.util;

public class ApiUtil {

    public static boolean  isFormatoDataInvalido(String data){
        return !data.matches("(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01])-([12]\\d{3})");
    }
}
