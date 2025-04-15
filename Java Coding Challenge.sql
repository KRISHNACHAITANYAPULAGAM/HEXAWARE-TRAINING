show schemas;
create schema InsuranceDB;
use InsuranceDB;

create table Policy( policyId INT PRIMARY KEY,
    policyName VARCHAR(100) NOT NULL,
    coverageDetails VARCHAR(255),
    premiumAmount DOUBLE);
    
select * from policy;