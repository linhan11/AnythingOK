#!/bin/sh

wget http://www.fine-today.net/loto/cgi/Loto/ExcelData/Loto6Data.txt
./generate-sql.rb > o.sql
