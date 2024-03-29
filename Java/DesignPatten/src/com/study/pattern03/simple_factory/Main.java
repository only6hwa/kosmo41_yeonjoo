package com.study.pattern03.simple_factory;

/*
 * simple Factory Pattern 
 * 6. 출력
 */


public class Main {

	public static void main(String[] args) {
		
		Unit unit1 = UnitFactory.createUnit(UnitType.Marine);
		Unit unit2 = UnitFactory.createUnit(UnitType.Firebat);
		Unit unit3 = UnitFactory.createUnit(UnitType.Medic);
		
		unit1.move();
		unit2.move();
		unit3.move();
		
	}

}
