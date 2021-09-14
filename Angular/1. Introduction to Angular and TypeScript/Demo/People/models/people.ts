export class Junior extends Employee {
    constructor(name: string, age: number) {
        super(name, age)
        this.tasks.push(' is working on a simple task.')
    }
}

export class Senior extends Employee {
    constructor(name: string, age: Number) {
        super(name, age);
        this.tasks.push(' is working on a complicated task.')
        this.tasks.push(' is taking time off work.')
        this.tasks.push(' is supervising junior workers.')
    }
}

export class Manager extends Employee {
    public divident: number;
    constructor(name: string, age: number) {
        super(name, age);
        this.divident = 0;
        this.tasks.push(' scheduled a meeting.');
        this.tasks.push(' is preparing a quarterly meeting.');
    }

    public getSalary(): number {
        return this.salary + this.divident;
    }
}