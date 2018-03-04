# ProducersConsumersMultithread

This is one of the many possible implementations of the well known "Producers-Consumers" problem.

This is based onto 2 classes:
- Consumer Class
- Producer Class

The "warehouse" is the shared Object which the threads will access in mutual exclusion, by atomic sessions.
The Shared Object has a queue for the pending processes that wait to have access.