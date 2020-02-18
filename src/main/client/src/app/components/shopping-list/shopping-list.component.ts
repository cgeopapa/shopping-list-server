import { Component, OnInit } from '@angular/core';
import { Item } from '../../item'
import { Logs } from 'selenium-webdriver';
import { trigger, transition, style, animate } from '@angular/animations';

@Component({
  selector: 'shopping-list',
  templateUrl: './shopping-list.component.html',
  styleUrls: ['./shopping-list.component.scss'],
  animations: [trigger('fade', [
    transition(':enter', [
      style({opacity: 0, transform: 'translateY(15px)'}),
      animate(200, style({opacity: 1, transform: 'translateY(0px)'}))
    ]),

    transition(':leave', [
      animate(200, style({opacity: 0, transform: 'translateY(30px)'}))
    ]),
  ])]
})
export class ShoppingListComponent implements OnInit 
{
  items: Item[];
  itemName: string;
  itemId: number = 3;
  itemNameCache: string;
  itemsRemaining: number;
  checkAllState: boolean;
  filter: string;

  constructor() { }

  ngOnInit() 
  {
    this.filter = 'all'
    this.items = [
      {
        'id': 1,
        'name': 'item 1',
        'bought': false,
        'editing': false
      },
      {
        'id': 2,
        'name': 'item 2',
        'bought': false,
        'editing': false
      }
    ]
  }

  addItem() : void
  {
    if(this.itemName.trim().length === 0)
    {
      console.log("wtf");
      return;
    }

    this.items.push({
      id: this.itemId,
      name: this.itemName,
      bought: false,
      editing: false
    })

    this.itemId++;
    this.itemName = '';
  }

  editItem(item: Item) : void
  {
    item.editing = !item.editing;
    if(item.editing)
    {
      this.itemNameCache = item.name;
    }
    else
    {
      if(item.name.trim().length > 0)
      {
        return;
      }
      item.name = this.itemNameCache;
    }
  }

  deleteItem(id: number)
  {
    this.items = this.items.filter(item => item.id !== id);
  }

  remainingItems(): number
  {
    return this.items.filter(item => !item.bought).length;
  }

  atLeastOneBought(): boolean
  {
    return this.items.filter(item => item.bought).length > 0;
  }

  clearBought(): void
  {
    this.items = this.items.filter(item=> !item.bought);
    this.checkAllState = false;
  }

  checkAll(): void
  {
    this.items.forEach(item =>
      {
        item.bought = !this.checkAllState;
      })
  }

  filterList(): Item[]
  {
    if(this.filter == 'all')
    {
      return this.items;
    }
    else if(this.filter == 'active')
    {
      return this.items.filter(item => !item.bought);
    }
    else
    {
      return this.items.filter(item => item.bought);
    }
  }
}
