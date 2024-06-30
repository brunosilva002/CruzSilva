import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'dateFormat'
})
export class DateFormatPipe implements PipeTransform {

  transform(value: string): string {
    if (!value) return value;

    // Parse the date string
    const date = new Date(value);

    // Get the day, month, and year parts
    const day = date.getDate().toString().padStart(2, '0');
    const month = (date.getMonth() + 1).toString().padStart(2, '0'); // Months are zero-based
    const year = date.getFullYear().toString().slice(2); // Get last two digits of the year

    // Return the formatted date string
    return `${day}/${month}/${year}`;
  }
}
