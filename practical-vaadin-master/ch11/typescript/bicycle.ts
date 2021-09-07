class Bicycle {
	private color: string;
	private speed: number = 0;
	private gear: number = 1;

	constructor(color: string) {
		this.color = color;
	}

	public speedUp(increase: number): void {
		this.speed += increase;
	}

	public applyBreak(decrease: number): number {
		return this.speed -= decrease;
	}

	public changeGear(newGear: number): number {
		return this.gear = newGear;
	}

	public print(): void {
		console.log(`${this.color} bicycle: ${this.speed} Km/h (${this.gear})`);
	}
}

let redBicycle = new Bicycle("red");
redBicycle.print();
redBicycle.speedUp(10);
redBicycle.changeGear(2);
redBicycle.speedUp(10);
redBicycle.changeGear(3);
redBicycle.speedUp(8);
redBicycle.applyBreak(5);
redBicycle.print();

// this will produce a compile time error:
// redBicycle.speedUp("10");
