import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken
import org.eclipse.paho.client.mqttv3.MqttCallback
import org.eclipse.paho.client.mqttv3.MqttMessage

/**
 * 处理MQ指令
 */
class MqttCallbackImpl : MqttCallback {
    override fun messageArrived(p0: String?, p1: MqttMessage?) {
        val msg = p0?.toString() + p1?.toString()
        Log.logger.info("messageArrived $msg")
    }

    override fun connectionLost(p0: Throwable?) {
        val msg = p0?.toString()
        Log.logger.error("connectionLost $msg")
    }

    override fun deliveryComplete(p0: IMqttDeliveryToken?) {
        val msg = p0?.toString()
        Log.logger.info("deliveryComplete $msg")
    }
}