package SortingAlgorithms.BubbleSort;

import Main.Item;
import Main.JSONHandler;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertArrayEquals;

public class BubbleSortTest {

    private ArrayList<Item> items = new ArrayList<>();
    private int[] ids;

    @Before
    public void initialize() {
        items = JSONHandler.getItemsArrayList();
        ids = new int[items.size()];
        for (int i = 0; i < ids.length; i++) {
            ids[i] = items.get(i).getItemNr();
        }
        System.out.println("All LEGO items were added to an ids array");
    }

    @Test
    public void sort() throws Exception {
        int[] expected = new int[]{620, 630, 2063, 2065, 2067, 2068, 2111, 2112, 2113, 2114, 2115, 2116, 2141, 2142, 2143, 2144, 2145, 2159, 2170, 2171, 2172, 2173, 2174, 2175, 2182, 2183, 2191, 2192, 2193, 2194, 2231, 2232, 2233, 2235, 2236, 2254, 2255, 2256, 2257, 2258, 2259, 2260, 2263, 2282, 2283, 2504, 2505, 2506, 2507, 2508, 2509, 2516, 2518, 2519, 2520, 2521, 2598, 2824, 3061, 3063, 3065, 3177, 3178, 3179, 3180, 3181, 3182, 3183, 3184, 3185, 3186, 3187, 3188, 3189, 3191, 3191, 3221, 3222, 3288, 3289, 3298, 3299, 3300, 3301, 3315, 3316, 3352, 3353, 3354, 3365, 3366, 3367, 3368, 3569, 3570, 3594, 3595, 3596, 3597, 3648, 3658, 3661, 3677, 3815, 3816, 3817, 3818, 3825, 3826, 3827, 3828, 3829, 3830, 3831, 3832, 3833, 3834, 3835, 3836, 3837, 3838, 3839, 3840, 3841, 3842, 3843, 3844, 3845, 3846, 3847, 3848, 3849, 3850, 3851, 3852, 3853, 3854, 3855, 3856, 3857, 3858, 3859, 3860, 3861, 3862, 3863, 3864, 3865, 3866, 3874, 3920, 3930, 3931, 3932, 3933, 3934, 3935, 3936, 3937, 3938, 3939, 3942, 4085, 4105, 4181, 4182, 4183, 4184, 4191, 4192, 4193, 4194, 4195, 4200, 4201, 4202, 4203, 4204, 4205, 4206, 4206, 4207, 4208, 4209, 4210, 4415, 4416, 4417, 4418, 4427, 4428, 4429, 4430, 4431, 4432, 4433, 4434, 4435, 4436, 4437, 4438, 4439, 4440, 4441, 4442, 4473, 4496, 4526, 4527, 4528, 4529, 4530, 4597, 4623, 4624, 4625, 4626, 4627, 4628, 4629, 4630, 4631, 4632, 4635, 4636, 4637, 4641, 4642, 4643, 4644, 4645, 4736, 4737, 4738, 4825, 4826, 4828, 4837, 4838, 4840, 4841, 4842, 4861, 4862, 4863, 4864, 4865, 4866, 4867, 4891, 4892, 4893, 4894, 4895, 4896, 4915, 4916, 4917, 4918, 4936, 4939, 4953, 4954, 4955, 4956, 4957, 4958, 4960, 4961, 4962, 4963, 4964, 4965, 4966, 4967, 4968, 4969, 4971, 4972, 4973, 4974, 4975, 4976, 4977, 4978, 4979, 4981, 4982, 4986, 4987, 4988, 4993, 4994, 4995, 4996, 4997, 4998, 5378, 5380, 5416, 5417, 5419, 5470, 5475, 5477, 5480, 5481, 5482, 5483, 5486, 5487, 5488, 5489, 5491, 5493, 5497, 5506, 5507, 5508, 5509, 5511, 5512, 5515, 5518, 5519, 5522, 5529, 5538, 5539, 5543, 5544, 5545, 5546, 5547, 5548, 5549, 5560, 5572, 5573, 5574, 5575, 5576, 5577, 5578, 5582, 5583, 5584, 5585, 5586, 5587, 5588, 5589, 5592, 5593, 5594, 5595, 5596, 5597, 5598, 5601, 5602, 5603, 5604, 5605, 5606, 5607, 5608, 5609, 5610, 5611, 5612, 5613, 5614, 5615, 5616, 5617, 5618, 5619, 5620, 5621, 5622, 5623, 5632, 5633, 5634, 5635, 5636, 5637, 5638, 5639, 5640, 5641, 5643, 5644, 5645, 5646, 5647, 5648, 5649, 5650, 5651, 5652, 5653, 5654, 5655, 5656, 5657, 5658, 5659, 5678, 5679, 5680, 5681, 5682, 5683, 5684, 5685, 5691, 5695, 5696, 5748, 5749, 5761, 5762, 5763, 5764, 5765, 5766, 5767, 5770, 5771, 5793, 5794, 5795, 5813, 5814, 5815, 5816, 5817, 5818, 5819, 5828, 5829, 5839, 5864, 5865, 5866, 5867, 5868, 5882, 5883, 5884, 5885, 5886, 5887, 5888, 5891, 5892, 5893, 5898, 5899, 5929, 5930, 5931, 5932, 5933, 5945, 5946, 5947, 5966, 5969, 5970, 5971, 5972, 5973, 5974, 5979, 5980, 5981, 5982, 5983, 5984, 5985, 6051, 6052, 6053, 6092, 6092, 6111, 6112, 6112, 6114, 6114, 6117, 6118, 6119, 6130, 6131, 6132, 6133, 6134, 6136, 6137, 6138, 6141, 6143, 6151, 6152, 6153, 6154, 6156, 6157, 6158, 6161, 6162, 6163, 6164, 6166, 6167, 6168, 6169, 6171, 6172, 6173, 6176, 6177, 6178, 6186, 6187, 6191, 6192, 6193, 6194, 6200, 6201, 6202, 6203, 6205, 6206, 6207, 6208, 6209, 6210, 6211, 6212, 6216, 6217, 6218, 6221, 6222, 6223, 6227, 6228, 6229, 6230, 6231, 6239, 6240, 6241, 6242, 6243, 6253, 6282, 6283, 6293, 6299, 6741, 6742, 6743, 6745, 6747, 6751, 6752, 6753, 6754, 6758, 6759, 6760, 6784, 6785, 6857, 6858, 6860, 6862, 6863, 6864, 6865, 6866, 6867, 6868, 6869, 6873, 6910, 6911, 6912, 6913, 6914, 6918, 7009, 7029, 7036, 7037, 7038, 7040, 7041, 7048, 7049, 7050, 7051, 7052, 7065, 7066, 7067, 7078, 7079, 7090, 7091, 7092, 7093, 7094, 7097, 7116, 7117, 7135, 7136, 7137, 7138, 7145, 7147, 7148, 7156, 7157, 7158, 7160, 7162, 7164, 7165, 7167, 7168, 7169, 7170, 7179, 7187, 7188, 7189, 7195, 7196, 7197, 7198, 7199, 7206, 7207, 7208, 7213, 7279, 7285, 7286, 7287, 7288, 7291, 7292, 7305, 7306, 7307, 7325, 7326, 7327, 7345, 7346, 7347, 7498, 7499, 7553, 7566, 7567, 7569, 7570, 7571, 7572, 7573, 7580, 7581, 7582, 7583, 7585, 7586, 7587, 7590, 7591, 7592, 7593, 7594, 7595, 7596, 7597, 7598, 7599, 7600, 7620, 7621, 7622, 7623, 7624, 7625, 7626, 7627, 7628, 7630, 7631, 7632, 7633, 7634, 7635, 7636, 7637, 7638, 7639, 7641, 7642, 7644, 7645, 7646, 7647, 7648, 7649, 7654, 7655, 7656, 7657, 7658, 7659, 7660, 7661, 7662, 7663, 7664, 7665, 7666, 7667, 7668, 7669, 7670, 7671, 7672, 7673, 7674, 7675, 7676, 7678, 7679, 7680, 7681, 7682, 7683, 7684, 7685, 7686, 7687, 7690, 7691, 7692, 7693, 7694, 7695, 7697, 7699, 7714, 7721, 7723, 7724, 7726, 7731, 7732, 7733, 7734, 7736, 7737, 7738, 7739, 7741, 7743, 7744, 7746, 7747, 7748, 7749, 7751, 7752, 7753, 7754, 7770, 7771, 7772, 7773, 7774, 7775, 7776, 7778, 7786, 7787, 7789, 7802, 7848, 7868, 7869, 7876, 7877, 7879, 7884, 7885, 7886, 7888, 7906, 7907, 7913, 7914, 7915, 7929, 7930, 7931, 7936, 7937, 7938, 7939, 7942, 7944, 7945, 7946, 7947, 7948, 7949, 7950, 7952, 7953, 7955, 7956, 7957, 7958, 7959, 7961, 7962, 7964, 7965, 7967, 7968, 7970, 7971, 7976, 7977, 7978, 7979, 7984, 7985, 7990, 7991, 7992, 7993, 7994, 7996, 7997, 7998, 8014, 8015, 8016, 8017, 8018, 8019, 8028, 8031, 8033, 8036, 8037, 8038, 8039, 8041, 8043, 8045, 8046, 8047, 8048, 8049, 8051, 8052, 8053, 8056, 8057, 8058, 8059, 8060, 8061, 8063, 8065, 8066, 8067, 8068, 8069, 8070, 8071, 8072, 8073, 8075, 8076, 8077, 8078, 8079, 8080, 8081, 8083, 8084, 8085, 8086, 8087, 8088, 8089, 8091, 8092, 8093, 8095, 8096, 8097, 8098, 8099, 8100, 8101, 8102, 8103, 8104, 8105, 8106, 8107, 8108, 8109, 8110, 8111, 8112, 8113, 8114, 8115, 8117, 8118, 8119, 8120, 8121, 8122, 8123, 8124, 8125, 8126, 8128, 8129, 8130, 8131, 8132, 8133, 8134, 8135, 8136, 8137, 8138, 8139, 8140, 8141, 8142, 8143, 8144, 8145, 8146, 8147, 8148, 8149, 8150, 8151, 8152, 8153, 8154, 8155, 8156, 8157, 8158, 8159, 8160, 8161, 8162, 8163, 8164, 8165, 8166, 8167, 8168, 8169, 8182, 8183, 8184, 8185, 8186, 8188, 8189, 8190, 8191, 8192, 8193, 8194, 8195, 8196, 8197, 8198, 8199, 8200, 8201, 8206, 8211, 8214, 8221, 8227, 8228, 8231, 8256, 8258, 8259, 8260, 8261, 8262, 8263, 8264, 8265, 8270, 8271, 8272, 8273, 8274, 8275, 8290, 8291, 8292, 8293, 8294, 8295, 8296, 8297, 8301, 8302, 8303, 8304, 8396, 8397, 8398, 8399, 8400, 8401, 8402, 8403, 8404, 8409, 8410, 8411, 8423, 8424, 8426, 8484, 8486, 8487, 8490, 8491, 8492, 8493, 8494, 8495, 8496, 8517, 8518, 8519, 8547, 8630, 8631, 8632, 8633, 8634, 8635, 8636, 8637, 8638, 8639, 8677, 8678, 8679, 8683, 8683, 8683, 8683, 8683, 8683, 8683, 8683, 8683, 8683, 8683, 8683, 8683, 8683, 8683, 8683, 8683, 8683, 8683, 8684, 8684, 8684, 8684, 8684, 8684, 8684, 8684, 8684, 8684, 8684, 8684, 8684, 8684, 8684, 8684, 8684, 8684, 8684, 8685, 8686, 8687, 8688, 8689, 8690, 8691, 8692, 8693, 8694, 8695, 8696, 8697, 8698, 8699, 8707, 8708, 8709, 8803, 8803, 8803, 8803, 8803, 8803, 8803, 8803, 8803, 8803, 8803, 8803, 8803, 8803, 8803, 8803, 8803, 8803, 8803, 8804, 8804, 8804, 8804, 8804, 8804, 8804, 8804, 8804, 8804, 8804, 8804, 8804, 8804, 8804, 8804, 8804, 8804, 8804, 8805, 8805, 8805, 8805, 8805, 8805, 8805, 8805, 8805, 8805, 8805, 8805, 8805, 8805, 8805, 8805, 8805, 8805, 8805, 8827, 8827, 8827, 8827, 8827, 8827, 8827, 8827, 8827, 8827, 8827, 8827, 8827, 8827, 8827, 8827, 8827, 8827, 8827, 8831, 8831, 8831, 8831, 8831, 8831, 8831, 8831, 8831, 8831, 8831, 8831, 8831, 8831, 8831, 8831, 8831, 8831, 8831, 8833, 8833, 8833, 8833, 8833, 8833, 8833, 8833, 8833, 8833, 8833, 8833, 8833, 8833, 8833, 8833, 8833, 8833, 8863, 8864, 8866, 8867, 8869, 8870, 8871, 8878, 8879, 8881, 8882, 8883, 8884, 8885, 8886, 8887, 8896, 8897, 8898, 8899, 8909, 8909, 8909, 8909, 8909, 8909, 8909, 8909, 8909, 8909, 8909, 8910, 8911, 8912, 8913, 8914, 8915, 8916, 8917, 8918, 8919, 8920, 8921, 8922, 8923, 8924, 8925, 8926, 8927, 8929, 8930, 8931, 8932, 8934, 8935, 8939, 8940, 8941, 8942, 8942, 8943, 8944, 8945, 8946, 8947, 8948, 8949, 8952, 8953, 8954, 8956, 8957, 8958, 8959, 8960, 8961, 8962, 8963, 8964, 8967, 8968, 8969, 8970, 8971, 8972, 8973, 8974, 8975, 8976, 8977, 8978, 8979, 8980, 8981, 8982, 8983, 8984, 8985, 8986, 8987, 8988, 8989, 8990, 8991, 8992, 8993, 8994, 8995, 8996, 8998, 9076, 9077, 9078, 9092, 9093, 9094, 9095, 9215, 9222, 9241, 9314, 9348, 9349, 9387, 9390, 9391, 9392, 9393, 9394, 9395, 9396, 9397, 9398, 9440, 9441, 9442, 9443, 9444, 9445, 9446, 9447, 9448, 9449, 9450, 9455, 9456, 9457, 9461, 9462, 9463, 9464, 9465, 9466, 9467, 9468, 9469, 9470, 9471, 9472, 9473, 9474, 9476, 9478, 9479, 9480, 9481, 9483, 9484, 9485, 9486, 9488, 9489, 9490, 9491, 9492, 9493, 9494, 9495, 9496, 9497, 9498, 9499, 9500, 9509, 9515, 9516, 9525, 9526, 9551, 9552, 9553, 9554, 9555, 9556, 9557, 9558, 9561, 9562, 9563, 9564, 9566, 9567, 9569, 9570, 9571, 9572, 9573, 9574, 9579, 9580, 9590, 9591, 9641, 9648, 9656, 9674, 9675, 9676, 9677, 9678, 9679, 9686, 9693, 9694, 9695, 9797, 10106, 10155, 10173, 10174, 10175, 10176, 10177, 10178, 10179, 10181, 10182, 10183, 10184, 10185, 10186, 10187, 10188, 10189, 10190, 10191, 10192, 10193, 10194, 10195, 10196, 10197, 10198, 10199, 10200, 10204, 10210, 10211, 10212, 10213, 10214, 10215, 10216, 10217, 10218, 10219, 10220, 10221, 10222, 10223, 10224, 10225, 10226, 10227, 10228, 10229, 10230, 10231, 10232, 10233, 10234, 10235, 10236, 10237, 10240, 10241, 10242, 10243, 10244, 10245, 10246, 10247, 10248, 10249, 10285, 10286, 10287, 10500, 10501, 10502, 10503, 10504, 10505, 10506, 10507, 10508, 10509, 10510, 10511, 10512, 10513, 10514, 10515, 10516, 10517, 10518, 10519, 10520, 10521, 10522, 10524, 10525, 10526, 10527, 10528, 10529, 10531, 10532, 10538, 10539, 10542, 10543, 10544, 10545, 10546, 10550, 10552, 10553, 10554, 10555, 10556, 10557, 10558, 10559, 10560, 10561, 10565, 10566, 10567, 10568, 10569, 10570, 10571, 10572, 10573, 10574, 10575, 10576, 10577, 10579, 10580, 10581, 10582, 10583, 10584, 10585, 10586, 10587, 10589, 10590, 10591, 10592, 10593, 10594, 10595, 10596, 10597, 10599, 10600, 10601, 10602, 10603, 10604, 10605, 10606, 10607, 10608, 10615, 10616, 10617, 10618, 10622, 10655, 10656, 10657, 10659, 10660, 10661, 10662, 10663, 10664, 10665, 10666, 10667, 10668, 10669, 10671, 10672, 10673, 10674, 10675, 10676, 10677, 10679, 10680, 10681, 10682, 10683, 10684, 10685, 10686, 10687, 10692, 10693, 10694, 10695, 10696, 10697, 10698, 10699, 10700, 10701, 10937, 20008, 20009, 20010, 20011, 20012, 20200, 20214, 20215, 20216, 20217, 21000, 21000, 21001, 21002, 21003, 21004, 21005, 21006, 21007, 21008, 21009, 21010, 21011, 21012, 21013, 21014, 21015, 21016, 21017, 21018, 21019, 21020, 21022, 21023, 21024, 21050, 21101, 21102, 21103, 21104, 21105, 21106, 21107, 21108, 21109, 21110, 21113, 21114, 21115, 21116, 21117, 21118, 21119, 21120, 21121, 21122, 21200, 21201, 21204, 21205, 21206, 21208, 21301, 21302, 21303, 30000, 30002, 30005, 30006, 30008, 30009, 30010, 30012, 30013, 30014, 30017, 30018, 30025, 30028, 30029, 30031, 30032, 30040, 30042, 30050, 30051, 30052, 30053, 30057, 30059, 30062, 30068, 30070, 30071, 30080, 30081, 30082, 30101, 30102, 30103, 30105, 30106, 30110, 30111, 30112, 30115, 30116, 30121, 30132, 30150, 30151, 30152, 30160, 30161, 30163, 30166, 30167, 30187, 30197, 30200, 30201, 30202, 30204, 30210, 30211, 30212, 30213, 30216, 30225, 30227, 30229, 30230, 30231, 30240, 30241, 30242, 30244, 30246, 30247, 30250, 30256, 30260, 30264, 30265, 30270, 30271, 30272, 30274, 30275, 30282, 30283, 30285, 30291, 30292, 30300, 30301, 30302, 30303, 30311, 30313, 30314, 30315, 31000, 31001, 31002, 31003, 31004, 31005, 31006, 31007, 31008, 31009, 31010, 31011, 31012, 31013, 31014, 31015, 31017, 31018, 31019, 31020, 31021, 31022, 31023, 31024, 31025, 31026, 31027, 31028, 31029, 31030, 31031, 31032, 31033, 31034, 31035, 31036, 31037, 31038, 31039, 31313, 40000, 40001, 40002, 40003, 40004, 40005, 40008, 40009, 40010, 40011, 40012, 40013, 40014, 40015, 40016, 40017, 40018, 40020, 40021, 40022, 40023, 40024, 40025, 40026, 40028, 40029, 40030, 40031, 40032, 40033, 40034, 40035, 40036, 40037, 40038, 40039, 40040, 40041, 40042, 40043, 40044, 40045, 40046, 40047, 40049, 40051, 40052, 40053, 40054, 40055, 40056, 40057, 40058, 40059, 40061, 40062, 40063, 40064, 40065, 40066, 40067, 40068, 40069, 40070, 40071, 40072, 40077, 40080, 40085, 40086, 40090, 40091, 40092, 40093, 40094, 40095, 40096, 40097, 40098, 40108, 40110, 40112, 40114, 40115, 40116, 40118, 40120, 40121, 40122, 40140, 40153, 40154, 40155, 40156, 40158, 40180, 40181, 40182, 40183, 41000, 41001, 41002, 41003, 41004, 41005, 41006, 41007, 41008, 41009, 41010, 41011, 41013, 41015, 41016, 41017, 41018, 41019, 41020, 41021, 41022, 41023, 41024, 41025, 41026, 41027, 41028, 41029, 41030, 41031, 41032, 41033, 41034, 41035, 41036, 41037, 41038, 41039, 41040, 41041, 41042, 41043, 41044, 41045, 41046, 41047, 41048, 41049, 41050, 41051, 41052, 41053, 41054, 41055, 41056, 41057, 41058, 41059, 41060, 41061, 41062, 41063, 41071, 41072, 41073, 41074, 41075, 41076, 41077, 41078, 41085, 41086, 41087, 41088, 41089, 41090, 41091, 41092, 41093, 41094, 41095, 41097, 41098, 41099, 41100, 41101, 41102, 41103, 41104, 41105, 41106, 41107, 41108, 41109, 41500, 41501, 41502, 41503, 41504, 41505, 41506, 41507, 41508, 41509, 41510, 41511, 41512, 41513, 41514, 41515, 41516, 41517, 41518, 41519, 41520, 41521, 41522, 41523, 41524, 41525, 41526, 41527, 41528, 41529, 41530, 41531, 41532, 41533, 41534, 41535, 41536, 41537, 41538, 41539, 41540, 41541, 41542, 41543, 41544, 41545, 41546, 41547, 41548, 41549, 41550, 41551, 41552, 41553, 41999, 42000, 42001, 42002, 42004, 42005, 42006, 42007, 42008, 42009, 42010, 42011, 42020, 42021, 42022, 42023, 42024, 42025, 42026, 42027, 42028, 42029, 42030, 42031, 42032, 42033, 42034, 42035, 42036, 42037, 42038, 42039, 42040, 42041, 42042, 42043, 44000, 44001, 44002, 44003, 44004, 44005, 44006, 44007, 44008, 44009, 44010, 44011, 44012, 44013, 44014, 44015, 44016, 44017, 44018, 44019, 44020, 44021, 44022, 44023, 44024, 44025, 44026, 44027, 44028, 44029, 45008, 45100, 45500, 45501, 45502, 45503, 45504, 45505, 45506, 45507, 45508, 45509, 45514, 45517, 45544, 45560, 50003, 50004, 50006, 50011, 55001, 60000, 60001, 60002, 60003, 60004, 60005, 60006, 60007, 60008, 60009, 60010, 60011, 60012, 60013, 60014, 60015, 60016, 60017, 60018, 60019, 60020, 60021, 60022, 60023, 60024, 60025, 60026, 60027, 60032, 60033, 60034, 60035, 60036, 60041, 60042, 60043, 60044, 60045, 60046, 60047, 60048, 60049, 60050, 60051, 60052, 60053, 60054, 60055, 60056, 60057, 60058, 60059, 60060, 60061, 60062, 60063, 60064, 60065, 60066, 60067, 60068, 60069, 60070, 60071, 60072, 60073, 60074, 60075, 60076, 60077, 60078, 60079, 60080, 60081, 60082, 60083, 60084, 60085, 60086, 60088, 60090, 60091, 60092, 60093, 60095, 60096, 60097, 60098, 60099, 66175, 66208, 66373, 66411, 66474, 66512, 70000, 70001, 70002, 70003, 70004, 70005, 70006, 70007, 70008, 70009, 70010, 70011, 70012, 70013, 70014, 70100, 70101, 70102, 70103, 70104, 70105, 70106, 70107, 70108, 70109, 70110, 70111, 70112, 70113, 70114, 70115, 70123, 70124, 70125, 70126, 70127, 70128, 70129, 70130, 70131, 70132, 70133, 70134, 70135, 70136, 70137, 70138, 70139, 70140, 70141, 70142, 70143, 70144, 70145, 70146, 70147, 70149, 70150, 70151, 70155, 70156, 70160, 70161, 70162, 70163, 70164, 70165, 70166, 70167, 70168, 70169, 70170, 70171, 70172, 70173, 70200, 70201, 70202, 70203, 70204, 70205, 70206, 70207, 70208, 70209, 70210, 70211, 70212, 70220, 70221, 70222, 70223, 70224, 70225, 70226, 70227, 70228, 70229, 70230, 70231, 70232, 70400, 70401, 70402, 70403, 70404, 70409, 70410, 70411, 70412, 70413, 70500, 70501, 70502, 70503, 70504, 70505, 70700, 70701, 70702, 70703, 70704, 70705, 70706, 70707, 70708, 70709, 70720, 70721, 70722, 70723, 70724, 70725, 70726, 70727, 70728, 70730, 70731, 70732, 70733, 70734, 70735, 70736, 70737, 70738, 70739, 70740, 70741, 70742, 70743, 70744, 70745, 70746, 70747, 70748, 70749, 70750, 70751, 70752, 70753, 70754, 70755, 70756, 70778, 70779, 70780, 70781, 70782, 70783, 70784, 70785, 70786, 70787, 70788, 70789, 70790, 70791, 70792, 70793, 70794, 70795, 70800, 70801, 70802, 70803, 70804, 70805, 70806, 70807, 70808, 70809, 70810, 70811, 70812, 70813, 70814, 70815, 70816, 70817, 70818, 70819, 71000, 71000, 71000, 71000, 71000, 71000, 71000, 71000, 71000, 71000, 71000, 71000, 71000, 71000, 71000, 71000, 71000, 71001, 71001, 71001, 71001, 71001, 71001, 71001, 71001, 71001, 71001, 71001, 71001, 71001, 71001, 71001, 71001, 71001, 71001, 71002, 71002, 71002, 71002, 71002, 71002, 71002, 71002, 71002, 71002, 71002, 71002, 71002, 71002, 71002, 71002, 71002, 71002, 71002, 71004, 71004, 71004, 71004, 71004, 71004, 71004, 71004, 71004, 71004, 71004, 71004, 71004, 71004, 71004, 71004, 71004, 71005, 71005, 71005, 71005, 71005, 71005, 71005, 71005, 71005, 71005, 71005, 71005, 71005, 71005, 71005, 71005, 71005, 71005, 71006, 71007, 71007, 71007, 71007, 71007, 71007, 71007, 71007, 71007, 71007, 71007, 71007, 71007, 71007, 71007, 71007, 71007, 71008, 71008, 71008, 71008, 71008, 71008, 71008, 71008, 71008, 71008, 71008, 71008, 71008, 71008, 71008, 71008, 71008, 71008, 71008, 71009, 71009, 71009, 71009, 71009, 71009, 71009, 71009, 71009, 71009, 71009, 71009, 71009, 71009, 71009, 71009, 71009, 71009, 71009, 71010, 71016, 75000, 75001, 75002, 75003, 75004, 75005, 75006, 75007, 75008, 75009, 75010, 75011, 75012, 75013, 75014, 75015, 75016, 75017, 75018, 75019, 75020, 75021, 75022, 75023, 75024, 75025, 75028, 75029, 75030, 75031, 75032, 75033, 75034, 75035, 75036, 75037, 75038, 75039, 75040, 75041, 75042, 75043, 75044, 75045, 75046, 75048, 75049, 75050, 75051, 75052, 75053, 75054, 75055, 75056, 75058, 75059, 75060, 75072, 75073, 75074, 75075, 75076, 75077, 75078, 75079, 75080, 75081, 75082, 75083, 75084, 75085, 75086, 75087, 75088, 75089, 75090, 75091, 75092, 75093, 75094, 75095, 75096, 75097, 75099, 75100, 75101, 75102, 75103, 75104, 75105, 75106, 75107, 75108, 75109, 75110, 75111, 75112, 75899, 75900, 75901, 75902, 75903, 75904, 75908, 75909, 75910, 75911, 75912, 75913, 75915, 75916, 75917, 75918, 75919, 75920, 76000, 76001, 76002, 76003, 76004, 76005, 76006, 76007, 76008, 76009, 76010, 76011, 76012, 76013, 76014, 76015, 76016, 76017, 76018, 76019, 76020, 76021, 76022, 76023, 76025, 76026, 76027, 76028, 76029, 76030, 76031, 76032, 76034, 76035, 76036, 76037, 76038, 76039, 76040, 76041, 76042, 79000, 79001, 79002, 79003, 79004, 79005, 79006, 79007, 79008, 79010, 79011, 79012, 79013, 79014, 79015, 79016, 79017, 79018, 79100, 79101, 79102, 79103, 79104, 79105, 79106, 79107, 79108, 79109, 79110, 79111, 79115, 79116, 79117, 79118, 79119, 79120, 79121, 79122, 88000, 88002, 88003, 88004, 850423, 850425, 850426, 850445, 850449, 850458, 850486, 850487, 850581, 850591, 850617, 850618, 850632, 850702, 850751, 850777, 850779, 850791, 850839, 850842, 850843, 850849, 850850, 850851, 850852, 850888, 850889, 850910, 850913, 850932, 850935, 850936, 850939, 850949, 850950, 850967, 851342, 851358, 851362, 852271, 852272, 852331, 852535, 852697, 852701, 852702, 852747, 852753, 852769, 852921, 852922, 852996, 853176, 853195, 853219, 853301, 853340, 853344, 853345, 853346, 853358, 853378, 853393, 853441, 853443, 2000409, 2000414, 2000430, 2000431, 2852724, 2852725, 2852726, 2853216, 2853590, 2855040, 2856079, 2856134, 2856197, 3300000, 3300001, 3300003, 3300014, 4521221, 4524081, 5000022, 5000023, 5000062, 5000063, 5000202, 5000245, 5000281, 5002122, 5002126, 5002144, 5002145, 5002941, 5003097, 5004076, 5004259, 5004735, 5004736, 5004737, 5004809, 5004815, 5004816, 5004817, 5004818, 5004819, 5004820, 6024305, 6031640, 6031641};

        assertArrayEquals(expected, BubbleSort.sort(ids));
    }
}