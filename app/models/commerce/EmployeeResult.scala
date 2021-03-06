/* Generated File */
package models.commerce

import java.time.LocalDateTime
import models.result.BaseResult
import models.result.filter.Filter
import models.result.orderBy.OrderBy
import models.result.paging.PagingOptions
import util.JsonSerializers._

final case class EmployeeResult(
    override val filters: Seq[Filter] = Nil,
    override val orderBys: Seq[OrderBy] = Nil,
    override val totalCount: Int = 0,
    override val paging: PagingOptions = PagingOptions(),
    override val results: Seq[Employee] = Nil,
    override val durationMs: Int = 0,
    override val occurred: LocalDateTime = util.DateUtils.now
) extends BaseResult[Employee]

object EmployeeResult {
  implicit val jsonEncoder: Encoder[EmployeeResult] = deriveEncoder
  implicit val jsonDecoder: Decoder[EmployeeResult] = deriveDecoder

  def fromRecords(
    q: Option[String], filters: Seq[Filter] = Nil, orderBys: Seq[OrderBy] = Nil, limit: Option[Int] = None, offset: Option[Int] = None,
    startMs: Long, totalCount: Int, results: Seq[Employee]
  ) = {
    val paging = PagingOptions.from(totalCount, limit, offset)
    val durationMs = (util.DateUtils.nowMillis - startMs).toInt
    EmployeeResult(paging = paging, filters = filters, orderBys = orderBys, totalCount = totalCount, results = results, durationMs = durationMs)
  }
}
