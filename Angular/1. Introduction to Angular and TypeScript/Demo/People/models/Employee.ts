abstract class Employee {
    name: string;
    age: number;
    salary: number;
    tasks: Array<string>;

    constructor(name, age) {
        this.name = name;
        this.age = age;
        this.salary = 0;
        this.tasks = [];
    }

    work(): void {
        const currentTask = this.tasks.shift();
        this.tasks.push(currentTask);
        console.log(this.name + currentTask);
    }

    collectSalary(): void {
        console.log(`${this.name} received ${this.getSalary()} this month.`)
    }

    getSalary(): number {
        return this.salary;
    }
}