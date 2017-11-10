/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.util.ArrayList;

/**
 *
 * @author Leandro Acosta <leandro.acosta292@hotmail.com>
 */
public class HomeStatus {

    public static ArrayList<String> getPopString() {
        return popString;
    }

    public static void setPopString(ArrayList<String> aPopString) {
        popString = aPopString;
    }

    private static int totalPops;
    private static int totalVersoes;
    private static int totalMelhorias;
    private static int totalUsuarios;
    private static int totalPesquisas;
    private static int totalVisualizacoes;
    private static ArrayList<String> popString;

    public static int getTotalPops() {
        return totalPops;
    }

    public static void setTotalPops(int aTotalPops) {
        totalPops = aTotalPops;
    }

    public static int getTotalVersoes() {
        return totalVersoes;
    }

    public static void setTotalVersoes(int aTotalVersoes) {
        totalVersoes = aTotalVersoes;
    }

    public static int getTotalMelhorias() {
        return totalMelhorias;
    }

    public static void setTotalMelhorias(int aTotalMelhorias) {
        totalMelhorias = aTotalMelhorias;
    }

    public static int getTotalUsuarios() {
        return totalUsuarios;
    }

    public static void setTotalUsuarios(int aTotalUsuarios) {
        totalUsuarios = aTotalUsuarios;
    }

    public static int getTotalPesquisas() {
        return totalPesquisas;
    }

    public static void setTotalPesquisas(int aTotalPesquisas) {
        totalPesquisas = aTotalPesquisas;
    }

    public static int getTotalVisualizacoes() {
        return totalVisualizacoes;
    }

    public static void setTotalVisualizacoes(int aTotalVisualizacoes) {
        totalVisualizacoes = aTotalVisualizacoes;
    }
}
