package ml.diamondbuildz.mostefficentpowerplantbudget;

import static ml.diamondbuildz.mostefficentpowerplantbudget.References.*;

public class Solution {
    private int wind, hydro, solar, coal, nuclear, EI, cost, MW;

    /**
     * Creates a solution for the project
     *
     * @param wind    Amount of Wind Power Plants
     * @param hydro   Amount of HydroElectric Plants
     * @param solar   Amount of Solar Power Plants
     * @param coal    Amount of Coal Power Plants
     * @param nuclear Amount of Nuclear Power Plants
     * @param EI      Total Enviromental Impact
     * @param cost    Total Cost
     * @param MW      Total MegaWatts
     */
    public Solution(int wind, int hydro, int solar, int coal, int nuclear, int EI, int cost, int MW) {
        this.wind = wind;
        this.hydro = hydro;
        this.solar = solar;
        this.coal = coal;
        this.nuclear = nuclear;
        this.EI = EI;
        this.cost = cost;
        this.MW = MW;
    }

    /**
     * Creates a solution for the project
     * Cost, EI and MW are automatically calculated
     *
     * @param wind    Amount of Wind Power Plants
     * @param hydro   Amount of HydroElectric Plants
     * @param solar   Amount of Solar Power Plants
     * @param coal    Amount of Coal Power Plants
     * @param nuclear Amount of Nuclear Power Plants
     **/
    public Solution(int wind, int hydro, int solar, int coal, int nuclear) {
        this.wind = wind;
        this.hydro = hydro;
        this.solar = solar;
        this.coal = coal;
        this.nuclear = nuclear;
        this.EI = (wind * windEI) + (hydro * hydroEI) + (solar * solarEI) + (coal * coalEI) + (nuclear * nuclearEI);
        this.cost = (wind * windCost) + (hydro * hydroCost) + (solar * solarCost) + (coal * coalCost) + (nuclear * nuclearCost);
        this.MW = (wind * windMW) + (hydro * hydroMW) + (solar * solarMW) + (coal * coalMW) + (nuclear * nuclearMW);
    }

    /**
     * Creates a solution for the project
     * All values are set to 0
     */
    public Solution() {
        this.wind = 0;
        this.hydro = 0;
        this.solar = 0;
        this.coal = 0;
        this.nuclear = 0;
        this.EI = 0;
        this.cost = 0;
        this.MW = 0;
    }

    public String toString() {
        return "Wind=" + wind + ", Hydro=" + hydro + ", Solar=" + solar + ", Coal=" + coal + ", Nuclear=" + nuclear + ", EI=" + EI + ", Cost=" + cost + ", MW=" + MW;
    }

    public int getWind() {
        return wind;
    }

    public void setWind(int wind) {
        this.wind = wind;
    }

    public int getHydro() {
        return hydro;
    }

    public void setHydro(int hydro) {
        this.hydro = hydro;
    }

    public int getSolar() {
        return solar;
    }

    public void setSolar(int solar) {
        this.solar = solar;
    }

    public int getCoal() {
        return coal;
    }

    public void setCoal(int coal) {
        this.coal = coal;
    }

    public int getNuclear() {
        return nuclear;
    }

    public void setNuclear(int nuclear) {
        this.nuclear = nuclear;
    }

    public int getEI() {
        return EI;
    }

    public void setEI(int EI) {
        this.EI = EI;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getMW() {
        return MW;
    }

    public void setMW(int MW) {
        this.MW = MW;
    }
}
