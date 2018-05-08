#!/usr/bin/env ruby                                 
require 'ostruct'                                   
require 'pp'                                        
                                                    
lotos = []                                          
File.open('./Loto6Data.txt').each do |line|         
  a = line.split(',')                               
  o = OpenStruct.new                                
  o.index = a[0]                                    
  o.date = a[1]                                     
  o.numbers = a[2..8].map{|e| e.to_i}               
  lotos << o                                        
end                                                 
                                                    
n = []                                              
lotos.each do |e|                                   
  n += e.numbers                                    
end                                                 
                                                    
h = {}                                              
n.map{|v| h[v] = n.count(v) unless h.has_key?(v)}   
pp h.sort{|a, b| b[1] <=> a[1]}                     
