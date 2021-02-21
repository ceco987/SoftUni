class Company {
    constructor() {
        this.departments = [];
    }

    addEmployee(username, salary, position, department) {
        if ([...arguments].some(e => e === '' || e === undefined || e === null)) throw new Error("Invalid input!");
        if (Number(salary) < 0) throw new Error("Invalid input!");

        let indexFound = this.departments.findIndex(e => e.department == department)
        if (indexFound == -1) {
            this.departments.push({
                department,
                employees: [{
                    username,
                    salary: Number(salary),
                    position
                }]
            })
        } else {
            this.departments[indexFound].employees.push({
                username,
                salary: Number(salary),
                position
            })
        }
        return `New employee is hired. Name: ${username}. Position: ${position}`
    }

    bestDepartment() {
        let bestDepName = '';
        let bestAvgSalary = Number.MIN_VALUE;

        this.departments.map(d => {
            let salCounter = 0;
            d.employees.map(e => salCounter += e.salary);
            if (salCounter / d.employees.length > bestAvgSalary) {
                bestAvgSalary = salCounter / d.employees.length;
                bestDepName = d.department;
            }
        }
        );

        let output = [`Best Department is: ${bestDepName}`];
        output.push(`Average salary: ${bestAvgSalary.toFixed(2)}`)
        this.departments.find(e => e.department == bestDepName)
            .employees
            .sort((a, b) => a.username.localeCompare(b.username))
            .sort((a, b) => b.salary - a.salary)
            .map(e => {
                output.push(`${e.username} ${e.salary} ${e.position}`)
            })

        return output.join('\n');
    }
}

let c = new Company();
c.addEmployee("Stanimir", 2000, "engineer", "Construction");
c.addEmployee("Pesho", 1500, "electrical engineer", "Construction");
c.addEmployee("Slavi", 500, "dyer", "Construction");
c.addEmployee("Stan", 2000, "architect", "Construction");
c.addEmployee("Stanimir", 1200, "digital marketing manager", "Marketing");
c.addEmployee("Pesho", 1000, "graphical designer", "Marketing");
c.addEmployee("Gosho", 1350, "HR", "Human resources");
console.log(c.bestDepartment());