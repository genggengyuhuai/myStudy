package design_pattern.handlerChain;

/**
 *  责任链模式   就是  Java Web 中的  FilterChain
 *  或者是 SpringMVC 中的 HandlerIntercept
 *   一个 Chain 包含了多个 Handler 处理逻辑
 *
 *  例如场景，用户参加一个活动可以领取奖品，但前提是要满足很多条件，比如首先需要校验用户是否是新用户、
 *   今日参与人数是否有限额、全场参与人数是否有限额等等。设定的规则都通过后，才能让用户领走奖品。
 *
 *   可以用单链表实现，也可以用 List<>
 * @author lihaoyu
 * @date 2/9/2020 3:40 PM
 */



public class HandlerChainTest {



}
