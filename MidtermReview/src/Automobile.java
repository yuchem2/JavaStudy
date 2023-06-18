class Automobile {

	private String model;
	private double miles;
	private int cylinder;
	private double displacement;
	private int grossHorsepower;
	private double rearAxleRatio;
	private double weight;
	private double mileTime;
	private int engine;
	private int transmission;
	private int forwardGears;
	private int carburetors;
	

	public Automobile(String model, double miles, int cylinder, double displacement, int grossHorsepower,
			double rearAxleRatio, double weight, double mileTime, int engine, int transmission,
			int forwardGears, int carburetors) {
		this.model = model;
		this.miles = miles;
		this.cylinder = cylinder;
		this.displacement = displacement;
		this.grossHorsepower = grossHorsepower;
		this.rearAxleRatio = rearAxleRatio;
		this.weight = weight;
		this.mileTime = mileTime;
		this.engine = engine;
		this.transmission = transmission;
		this.forwardGears = forwardGears;
		this.carburetors = carburetors;
	}

	public Automobile(String model, double miles) {
		this.model = model;
		this.miles = miles;
		this.cylinder = 0;
		this.displacement = 0.0;
		this.grossHorsepower = 0;
		this.rearAxleRatio = 0.0;
		this.weight = 0.0;
		this.mileTime = 0.0;
		this.engine = 0;
		this.transmission = 0;
		this.forwardGears = 0;
		this.carburetors = 0;
	}

	public Automobile(String model, double miles, int cylinder) {
		this.model = model;
		this.miles = miles;
		this.cylinder = cylinder;
		this.displacement = 0.0;
		this.grossHorsepower = 0;
		this.rearAxleRatio = 0.0;
		this.weight = 0.0;
		this.mileTime = 0.0;
		this.engine = 0;
		this.transmission = 0;
		this.forwardGears = 0;
		this.carburetors = 0;
	}

	public Automobile(String str) {
		model = str.substring(0, str.indexOf("\t"));
		str = str.substring(str.indexOf("\t") + 1);
		miles = Double.parseDouble(str.substring(0, str.indexOf("\t")));
		str = str.substring(str.indexOf("\t") + 1);
		cylinder = Integer.parseInt(str.substring(0, str.indexOf("\t")));
		str = str.substring(str.indexOf("\t") + 1);
		displacement = Double.parseDouble(str.substring(0, str.indexOf("\t")));
		str = str.substring(str.indexOf("\t") + 1);
		grossHorsepower = Integer.parseInt(str.substring(0, str.indexOf("\t")));
		str = str.substring(str.indexOf("\t") + 1);
		rearAxleRatio = Double.parseDouble(str.substring(0, str.indexOf("\t")));
		str = str.substring(str.indexOf("\t") + 1);
		weight = Double.parseDouble(str.substring(0, str.indexOf("\t")));
		str = str.substring(str.indexOf("\t") + 1);
		mileTime = Double.parseDouble(str.substring(0, str.indexOf("\t")));
		str = str.substring(str.indexOf("\t") + 1);
		engine = Integer.parseInt(str.substring(0, str.indexOf("\t")));
		str = str.substring(str.indexOf("\t") + 1);
		transmission = Integer.parseInt(str.substring(0, str.indexOf("\t")));
		str = str.substring(str.indexOf("\t") + 1);
		forwardGears = Integer.parseInt(str.substring(0, str.indexOf("\t")));
		carburetors = Integer.parseInt(str.substring(str.indexOf("\t") + 1));
	}

	public String getmodel() {
		return model;
	}

	public double getMiles() {
		return miles;
	}

	public int getCylinder() {
		return cylinder;
	}

	public double getDisplacement() {
		return displacement;
	}

	public int getGrossHorsepower() {
		return grossHorsepower;
	}

	public double getRearAxleRatio() {
		return rearAxleRatio;
	}

	public double getWeight() {
		return weight;
	}

	public double getMileTime() {
		return mileTime;
	}

	public int hasEngine() {
		return engine;
	}

	public int hasTransmission() {
		return transmission;
	}

	public int getForwardGears() {
		return forwardGears;
	}

	public int getCarburetors() {
		return carburetors;
	}

	// Setter 메서드
	public void setmodel(String model) {
		this.model = model;
	}

	public void setMiles(double miles) {
		this.miles = miles;
	}

	public void setCylinder(int cylinder) {
		this.cylinder = cylinder;
	}

	public void setDisplacement(double displacement) {
		this.displacement = displacement;
	}

	public void setGrossHorsepower(int grossHorsepower) {
		this.grossHorsepower = grossHorsepower;
	}

	public void setRearAxleRatio(double rearAxleRatio) {
		this.rearAxleRatio = rearAxleRatio;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public void setMileTime(double mileTime) {
		this.mileTime = mileTime;
	}

	public void setEngine(int engine) {
		this.engine = engine;
	}

	public void setTransmission(int transmission) {
		this.transmission = transmission;
	}

	public void setForwardGears(int forwardGears) {
		this.forwardGears = forwardGears;
	}

	public void setCarburetors(int carburetors) {
		this.carburetors = carburetors;
	}

	public void printInformation() {
		System.out.println("Model: " + model);
		System.out.println("Miles/(US) gallon: " + miles);
		System.out.println("Number of cylinders: " + cylinder);
		System.out.println("Displacement (cu.in.): " + displacement);
		System.out.println("Gross horsepower: " + grossHorsepower);
		System.out.println("Rear axle ratio: " + rearAxleRatio);
		System.out.println("Weight (1000 lbs): " + weight);
		System.out.println("1/4 mile time: " + mileTime);
		System.out.println("Engine (0 = V-shaped, 1 = straight): " + engine);
		System.out.println("Transmission (0 = automatic, 1 = manual): " + transmission);
		System.out.println("Number of forward gears: " + forwardGears);
		System.out.println("Number of carburetors: " + carburetors);
	}

}
