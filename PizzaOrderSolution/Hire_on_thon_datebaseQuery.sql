
select branchId from (select branchId, count(branchId) as noOfOrder from orderHistory where createdDate >= startDateOfCurrentMonth group by (branchId)) order by noOfOrder DESC limit 1;