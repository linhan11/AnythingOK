#!/usr/bin/env ruby

File.open('./Loto6Data.txt').each do |l|
	a = l.split(',')
	puts %Q(INSERT INTO loto_masters (loto_index, loto_date, victory_number, victory_amount, victory_people, carry_over) VALUES ('%s', '%s', '%s', '%s', '%s', '%s');) %
		[a[0], a[1], a[2..8].join(','), a[9..13].join(','), a[14..18].join(','), a[19]]
end
