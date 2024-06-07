package com.git.sweetmanager.dashboard.domain.model.aggregates;

import com.git.sweetmanager.dashboard.domain.model.commands.monthlychart.CreateMonthlyChartCommand;
import com.git.sweetmanager.shared.domain.aggregates.AuditableAbstractAggregateRoot;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "monthlyChart")
public class MonthlyChart extends AuditableAbstractAggregateRoot<MonthlyChart> {

    // Attributes
    private String month;
    private int total;

    // Constructors
    public MonthlyChart(String month, int total){
        this.month = month;
        this.total = total;
    }

    public MonthlyChart(CreateMonthlyChartCommand command) {
        this.month = command.month();
        this.total = command.total();
    }

    public MonthlyChart(){

    }

    // Methods
    public void updateMonth(String month){
        this.month = month;
    }

    public void updateTotal(int total){
        this.total = total;
    }

    public String getMonth() {
        return month;
    }

    public int getTotal() {
        return total;
    }
}