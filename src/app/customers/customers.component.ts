import {Component, OnInit} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {MatTableDataSource} from '@angular/material/table';

@Component({
  selector: 'app-customers',
  standalone: false,
  templateUrl: './customers.component.html',
  styleUrl: './customers.component.css'
})
export class CustomersComponent implements OnInit{

  public customers : any;
  public dataSource : any;
  public displayedColumns  = ['name', 'code', 'email', 'address'];

  constructor(private http : HttpClient ) {
  }

  ngOnInit(): void {
       this.http.get("http://localhost:8081/customer")
         .subscribe( {
           next : data => {
             this.customers = data;
             this.dataSource = new MatTableDataSource(this.customers);
           },
           error : err => {
             console.log(err);
           }
         })
    }

}
