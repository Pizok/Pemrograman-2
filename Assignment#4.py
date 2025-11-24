#this code has a bug: it asks for name of passengers based on the capacity NOT BY THE NUMBER OF PASSENGERS

class Vehicle:
    def __init__(self, name, capacity):
        self.name = name
        self.capacity = capacity
        self.passenger = 0
        self.number = 0 
    
    # New method to assign passenger & number attibutes
    def use (self, number_Of_Vehicle, number_Of_Passenger):
        self.passenger = number_Of_Passenger
        self.number = number_Of_Vehicle

class Bus(Vehicle):
    def __init__(self):
        super().__init__("Bus", 40)

class Car(Vehicle):
    def __init__(self):
        super().__init__("Car", 4)

class Motorcycle(Vehicle):
    def __init__(self):
        super().__init__("Motorcycle", 2)

class TransportSystem:
    
    def __init__(self):
        self.vehicles = [
            Bus(),
            Car(),
            Motorcycle()
        ]
    
    def calculate_vehicles(self, passengers):
        vehicle_Used = []
        
        for vehicle in self.vehicles:
            count = passengers // vehicle.capacity  # How many vehicles of this type are needed
            remaining = passengers % vehicle.capacity # How many passangers left

            # create full vehicles
            if count > 0:
                vehicle_number = 1
                for i in range(count):
                    vehicle_assign = type(vehicle)()
                    vehicle_assign.use(vehicle_number, vehicle.capacity)  # Full Capacity because the use type of vehicle is if same with max. capacity)
                    vehicle_Used.append(vehicle_assign)
                    vehicle_number += 1
            
            passengers = remaining # Remaining passengers

        # If there are remaining passengers, add one more motorcycle (as fallback)
        if passengers > 0:
            smallest = self.vehicles[-1]  # motorcycle
            last = type(smallest)( )
            last_number = len(vehicle_Used) + 1
            last.use(last_number, passengers)  # assign only remaining passengers
            vehicle_Used.append(last)
        
        return vehicle_Used


def main():
    transport_system = TransportSystem()
    vehicles_with_passengers = {}
    
    # Ask the user for the number of passengers
    passengers = int(input("Enter the number of passengers: "))
    
    # Calculate how many vehicles are needed
    result = transport_system.calculate_vehicles(passengers)

    # Collect passenger names based on assigned passenger count
    for vehicle in result:
        print(f"\nEntering names for {vehicle.name} #{vehicle.number}:")
        passenger_list = []

        for i in range(vehicle.passenger):   # ask only for the assigned amount
            p = input(f"Enter passenger name - {i + 1}: ")
            passenger_list.append(p)

        # group by vehicle type
        if vehicle.name not in vehicles_with_passengers:
            vehicles_with_passengers[vehicle.name] = []
        vehicles_with_passengers[vehicle.name].append(passenger_list)

    # Output vehicle use summary
    print("\nSummary of Vehicles and their Passengers:")
    for vehicle_name, groups in vehicles_with_passengers.items():
        print(f"{vehicle_name}:")
        for i, passenger_list in enumerate(groups, 1):
            print(f"  {vehicle_name} #{i} passengers: {', '.join(passenger_list)}")


if __name__ == "__main__":
    main()