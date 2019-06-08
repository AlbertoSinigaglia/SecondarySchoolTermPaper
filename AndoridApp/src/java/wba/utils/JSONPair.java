/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wba.utils;

import com.google.gson.annotations.Expose;
import java.util.ArrayList;

/**
 *
 * @author alberto
 */
public class JSONPair{
        @Expose
        public ArrayList<Integer> id=new ArrayList<>();
        @Expose
        public ArrayList<String> nome=new ArrayList<>();
        public JSONPair() {}
        public ArrayList<Integer> getId() {return id;}
        public void setId(ArrayList<Integer> id) {this.id = id;}
        public ArrayList<String> getNome() {return nome;}
        public void setNome(ArrayList<String> nome) {this.nome = nome;}
        
        public void add(int id, String nome){
            this.id.add(id);
            this.nome.add(nome);
        }
        @Override
        public String toString(){
            return id.toString()+nome.toString();
        }
    }