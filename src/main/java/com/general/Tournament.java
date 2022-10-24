package com.general;

import java.sql.Date;

public class Tournament {
    public String name;
    public Date startDate;

    public Date getStartDate{
        return this.startDate;
    }
    public void setStartDate{
        this.startDate = startDate;
    }

    public Date endDate;

    public Date getEndDate{
        return this.endDate;
    }

    public void setEndDate{
        this.endDate = endDate;
    }

    public String location;

    public String getLocation{
        return this.location;
    }
    public void setLocation{
        this.location = location;
    }

    public double entryFee;

    public double getEntryFee{
        return this.entryFee;
    }
    public void setEntryFee{
        this.entryFee = entryFee;
    }

    public double cashPrice;

    public double getCashPrice{
        return this.cashPrice;
    }
    public void setCashPrice{
        this.cashPrice = cashPrice;
    }

    public member extends Members;

    public String finalStandings;
}
