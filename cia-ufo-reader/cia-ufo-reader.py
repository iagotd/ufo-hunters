from kafka import KafkaConsumer

TOPIC_NAME = 'ufo-sightings'

consumer = KafkaConsumer(TOPIC_NAME)
for message in consumer:
    print(message)
