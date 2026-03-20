INSERT INTO expenses (category, amount, date, description)
SELECT 'Groceries', 85.50, '2026-03-18', 'Weekly grocery shopping'
WHERE NOT EXISTS (SELECT 1 FROM expenses WHERE description = 'Weekly grocery shopping');

INSERT INTO expenses (category, amount, date, description)
SELECT 'Utilities', 120.00, '2026-03-19', 'Monthly electricity bill'
WHERE NOT EXISTS (SELECT 1 FROM expenses WHERE description = 'Monthly electricity bill');

INSERT INTO expenses (category, amount, date, description)
SELECT 'Entertainment', 45.00, '2026-03-20', 'Cinema tickets and popcorn'
WHERE NOT EXISTS (SELECT 1 FROM expenses WHERE description = 'Cinema tickets and popcorn');